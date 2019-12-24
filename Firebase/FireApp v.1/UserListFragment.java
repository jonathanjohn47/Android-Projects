package com.example.fireapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.client.Firebase;


public class UserListFragment extends Fragment implements View.OnClickListener {

    private EditText mEdtUserName, mEdtUserProfession, mEdtUserAge;
    private Button mBtnAdd;

    private Firebase mRootRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_details_fragment, container,false);

        mRootRef = new Firebase("https://fireapp-ac271.firebaseio.com/Users");

        mEdtUserName = view.findViewById(R.id.edtUserName);
        mEdtUserAge = view.findViewById(R.id.edtUserAge);
        mEdtUserProfession = view.findViewById(R.id.edtUserProfession);
        mBtnAdd = view.findViewById(R.id.btnAdd);
        //TODO: set OnCLickLIstener to the button\
        mBtnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public UserListFragment() {
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd){

            String name = mEdtUserName.getText().toString().trim();
            String age = mEdtUserAge.getText().toString().trim();
            String profession = mEdtUserProfession.getText().toString().trim();
            Firebase mChild = mRootRef.child(name);
            mChild.setValue(null);
            Firebase mChildAge = mChild.child("Age");
            mChildAge.setValue(age);
            Firebase mChildProfession = mChild.child("Profession");
            mChildProfession.setValue(profession);

            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        }
    }
}
