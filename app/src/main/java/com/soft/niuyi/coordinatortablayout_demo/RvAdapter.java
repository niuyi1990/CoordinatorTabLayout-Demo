package com.soft.niuyi.coordinatortablayout_demo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 作者：牛毅
 * 时间：2017/02/21 15：35
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class RvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RvAdapter(List<String> data) {
        super(R.layout.item_rv, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }


}
