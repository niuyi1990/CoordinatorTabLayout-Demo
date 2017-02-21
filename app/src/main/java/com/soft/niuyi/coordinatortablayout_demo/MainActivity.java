package com.soft.niuyi.coordinatortablayout_demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_viewpager)
    TabLayout mTabViewpager;
    @BindView(R.id.vp_tablayout)
    ViewPager mVpTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        List<Fragment> list = initFragment();
        List<String> titleList = initTitle();

        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), list,titleList);
        mVpTablayout.setAdapter(adapter);
        mTabViewpager.setupWithViewPager(mVpTablayout);
    }

    private List<String> initTitle() {
        List<String> list = new ArrayList<>();
        list.add("中国");
        list.add("美国");
        list.add("德国");
        list.add("法国");
        return list;
    }

    private List<Fragment> initFragment() {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(PagerFragment.newInstance());
        }
        return list;
    }

}
