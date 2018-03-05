package com.example.zhoubiao.cxcourses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhoubiao.cxcourses.fragment.AllCourseFragment;
import com.example.zhoubiao.cxcourses.fragment.Allcoursefragment_1;
import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;

/**
 * Created by BUPTIET on 2016/5/16.
 */
public class Category extends Fragment {
    private TextView course_1;
    private TextView course_2;
    private ViewPager viewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.category_viewpager);
        course_1 = (TextView) view.findViewById(R.id.course_1);
        course_2 = (TextView) view.findViewById(R.id.course_2);
        course_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                course_1.setBackgroundColor(getResources().getColor(R.color.verso));
                course_2.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        course_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                course_2.setBackgroundColor(getResources().getColor(R.color.verso));
                course_1.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        NavigationAdapter navigationAdapter = new NavigationAdapter(getFragmentManager());
        viewPager.setAdapter(navigationAdapter);
        return view;
    }

    class NavigationAdapter extends CacheFragmentStatePagerAdapter {

        public NavigationAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        protected Fragment createItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new AllCourseFragment();
                    break;
                case 1:
                    fragment = new Allcoursefragment_1();
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}