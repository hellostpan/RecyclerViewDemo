package stpan.recyclerviewdemo.adapter;

import android.content.Context;


import java.util.List;

import stpan.recyclerviewdemo.R;

/**
 * 功能：
 * 创建时间:2016/1/25 15:17
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdapter<String> {


    public RecyclerViewAdapter(Context context, List<String> list) {
        super(context, list, R.layout.adapter_recyclerview_demo);
    }

    @Override
    public void convert(RecyclerViewHolder holder, String item) {
        holder.setText(R.id.tv_adp_recycler_view,item);
    }
}
