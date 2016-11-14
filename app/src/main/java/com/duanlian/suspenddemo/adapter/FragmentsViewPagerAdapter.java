package com.duanlian.suspenddemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


import com.duanlian.suspenddemo.BaseFragment;

import java.util.List;

public class FragmentsViewPagerAdapter extends FragmentPagerAdapter {

    private List<? extends BaseFragment> fragList;
    private List<String> titleList;

    public FragmentsViewPagerAdapter(FragmentManager fm, List<? extends BaseFragment> fragments,List<String> titleList) {
        super(fm);
        this.fragList = fragments;
        this.titleList = titleList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        return super.instantiateItem(container, position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);//页卡标题
    }
}
