package com.example.jonathan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.UploadTask;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentDetails extends AppCompatActivity {

    private CircularImageView mImgStudentProfilePic;

    private EditText mTxtSetName, mTxtSetCourse, mTxtSetSchool;
    private Button mBtnSync;

    private String UserEmail;
    private String UserUID;

    private DatabaseReference myRef;

    private LinearLayout mLayout;

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        init();
        setOnClickListeners(mImgStudentProfilePic, mBtnSync);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        UserEmail = b.getString("Email");
        UserUID = b.getString("UID");

        String context = b.getString("Context");
        if (context.equals("Login Page")) {
            displayStudentDetails();
        }
    }

    private void setOnClickListeners(View... views){
        views[0].setOnClickListener(new ImgStudentProfilePicOnClickListener());
        views[1].setOnClickListener(new BtnSyncClickListener());
    }

    private class BtnSyncClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String name, course, school;
            name = mTxtSetName.getText().toString().trim();
            course = mTxtSetCourse.getText().toString().trim();
            school = mTxtSetSchool.getText().toString().trim();
            writeNewStudent(UserUID, name, UserEmail, course, school);
        }
    }

    private void init(){
        mImgStudentProfilePic = findViewById(R.id.imgStudentProfilePic);
        mTxtSetName = findViewById(R.id.txtSetName);
        mTxtSetCourse = findViewById(R.id.txtSetCourse);
        mTxtSetSchool = findViewById(R.id.txtSetSchool);

        myRef = FirebaseDatabase.getInstance().getReference("Students");

        mBtnSync = findViewById(R.id.btnSync);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mLayout = findViewById(R.id.studentDetailsLayout);
        registerForContextMenu(mLayout);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UserUID = user.getUid();
        UserEmail = user.getEmail();
    }

    private void displayStudentDetails() {
        final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        final ProgressDialog dialog = new ProgressDialog(StudentDetails.this);
        dialog.setMessage("Fetching Data...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        dialog.show();
                    }
                });
            }
        };
        final Thread thread = new Thread(runnable);
        thread.start();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Students");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (dataSnapshot.getKey().equals(uid)){

                    Student student = dataSnapshot.getValue(Student.class);
                    mTxtSetName.setText(student.getName());
                    mTxtSetSchool.setText(student.getSchool());
                    mTxtSetCourse.setText(student.getCourse());

                    StorageReference islandRef = mStorageRef.child(dataSnapshot.getKey());

                    final long ONE_MEGABYTE = 1024 * 1024;
                    islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            mImgStudentProfilePic.setImageBitmap(bitmap);
                            dialog.dismiss();
                            thread.interrupt();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {

                        }
                    });
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private class ImgStudentProfilePicOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 1);
        }
    }

    private Uri selectedImage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            if (requestCode == 1 && resultCode == RESULT_OK){
                selectedImage = data.getData();
                mImgStudentProfilePic.setImageURI(selectedImage);
            }
        }
    }


    private void writeNewStudent(final String UserUID, final String name, final String email, final String course, final String school){
        final ProgressDialog progressDialog = new ProgressDialog(StudentDetails.this);


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    Student student = new Student(name, course, school);
                    student.setEmail(email);

                    DatabaseReference dbStudent = myRef.child(UserUID);
                    dbStudent.setValue(student);
                }
                else{
                    Student student = new Student(name, course, school);
                    student.setEmail(email);

                    DatabaseReference dbStudent = myRef.child(UserUID);
                    dbStudent.setValue(student);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if (selectedImage!=null) {
            StorageReference reference = mStorageRef.child("" + UserUID);

            reference.putFile(selectedImage)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            mt("Something Went Wrong!");
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                               @Override
                                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                                   progressDialog.setMessage("Uploading Image...");
                                                   progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                                   progressDialog.show();
                                               }
                                           }
                    );
        }
        alertDialog("Sync Complete", "All Data have been saved on Database.");
        selectedImage = null;
    }

    private void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private void alertDialog(String heading, String message){
        final AlertDialog alertDialog = new AlertDialog.Builder(StudentDetails.this).create();
        alertDialog.setTitle(heading);
        alertDialog.setMessage(message);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.student_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.listOfStudents){
            Intent intent = new Intent(StudentDetails.this, StudentList.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
