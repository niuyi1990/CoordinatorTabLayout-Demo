package com.soft.niuyi.coordinatortablayout_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：
 * 时间：2017/02/21 15：12
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class VpAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    private List<String> mTitle;

    public VpAdapter(FragmentManager fm, List<Fragment> list, List<String> titleList) {
        super(fm);
        this.mList = list;
        this.mTitle = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
