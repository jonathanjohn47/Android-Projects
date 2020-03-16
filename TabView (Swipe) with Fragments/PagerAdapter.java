package com.academyjohn.johnacademyadmin;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.academyjohn.johnacademyadmin.Fragments.AttendanceFragment;
import com.academyjohn.johnacademyadmin.Fragments.HomeWorkFragment;

public class PageAdapter extends FragmentPagerAdapter {

    int noOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                AttendanceFragment attendanceFragment = new AttendanceFragment();
                return attendanceFragment;
            }
            case 1: {
                HomeWorkFragment homeWorkFragment = new HomeWorkFragment();
                return homeWorkFragment;
            }
            default:{
                AttendanceFragment attendanceFragment = new AttendanceFragment();
                return attendanceFragment;
            }
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Attendance";
        }
        else {
            return "Homework";
        }
    }
}
