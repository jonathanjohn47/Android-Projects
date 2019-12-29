package com.example.jonathan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.ViewHolder> {


    public StudentRecyclerViewAdapter(ArrayList<Student> mAllStudent) {
        this.mAllStudent = mAllStudent;
    }

    private ArrayList<Student> mAllStudent;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_inflater, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = mAllStudent.get(position);
        String name = student.getName();
        String course = student.getCourse();
        holder.txtStudentName.setText(name);
        holder.txtCourse.setText(course);
    }

    @Override
    public int getItemCount() {
        return mAllStudent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtStudentName, txtCourse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentName = itemView.findViewById(R.id.txtStudentName);
            txtCourse = itemView.findViewById(R.id.txtStudentCourse);
        }
    }
}
