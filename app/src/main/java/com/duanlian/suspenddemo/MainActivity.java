package com.duanlian.suspenddemo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duanlian.suspenddemo.adapter.FragmentsViewPagerAdapter;
import com.duanlian.suspenddemo.fragment.ListViewFragment;
import com.duanlian.suspenddemo.fragment.RecycleViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<String> titleList;
    private TabLayout mTab;
    private LinearLayout mLinearLayout;
    private StickyNavLayout stick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
        mLinearLayout = (LinearLayout) findViewById(R.id.id_stickynavlayout_topview);
        stick = (StickyNavLayout) findViewById(R.id.stick);
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(ListViewFragment.newInstance());
        fragments.add(RecycleViewFragment.newInstance());
        //设置标题
        titleList = new ArrayList<>();
        titleList.add("江一燕");
        titleList.add("佟丽娅");
        mTab = (TabLayout) findViewById(R.id.id_stickynavlayout_indicator);
        //设置tab的模式
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mLinearLayout.setFocusable(true);
        FragmentsViewPagerAdapter adapter = new FragmentsViewPagerAdapter(getSupportFragmentManager(), fragments,titleList);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
        stick.setOnStickStateChangeListener(new StickyNavLayout.onStickStateChangeListener() {
            @Override
            public void isStick(boolean isStick) {
                if (isStick) {
                    mTab.setBackgroundColor(Color.BLUE);
                } else {
                    mTab.setBackgroundColor(Color.WHITE);
                }
            }

            @Override
            public void scrollPercent(float percent) {

            }
        });
    }
}
