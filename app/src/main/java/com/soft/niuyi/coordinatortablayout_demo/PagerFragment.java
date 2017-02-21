package com.soft.niuyi.coordinatortablayout_demo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：牛毅
 * 时间：2017/02/21 15：14
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class PagerFragment extends Fragment implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private Context mContext;
    private RvAdapter mRvAdapter;

    boolean isErr = false;

    public static PagerFragment newInstance() {
        Bundle args = new Bundle();
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initList();
    }

    private void initList() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("我是第" + i + "几条数据");
        }

        mRvAdapter = new RvAdapter(list);

        mRvAdapter.setOnLoadMoreListener(this);
//        mRvAdapter.setLoadMoreView(new CustomLoadMoreView());//自定义上拉加载布局
//        mInlandGoodsAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        mAdapter.setAutoLoadMoreSize(3);//距离底布多少item预加载

        mRvList.setLayoutManager(new LinearLayoutManager(mContext));
        mRvList.setAdapter(mRvAdapter);

        mRvList.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoadMoreRequested() {
        new Handler().postDelayed(new Runnable() {//延迟3秒加载
            @Override
            public void run() {
                if (!isErr) {
                    mRvAdapter.loadMoreFail();
                    isErr = true;
                } else {
                    mRvAdapter.loadMoreEnd();
                }
            }

        }, 3000);
    }
}
