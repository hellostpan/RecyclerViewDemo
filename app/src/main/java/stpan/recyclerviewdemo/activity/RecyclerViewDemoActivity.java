package stpan.recyclerviewdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import stpan.recyclerviewdemo.R;
import stpan.recyclerviewdemo.adapter.OnItemClickListener;
import stpan.recyclerviewdemo.adapter.OnItemLongClickListener;
import stpan.recyclerviewdemo.adapter.RecyclerViewAdapter;
import stpan.recyclerviewdemo.animators.LandingAnimator;

/**
 * 功能：
 * 创建时间:2016/1/22 16:16
 * 作者:pst
 */
public class RecyclerViewDemoActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> list;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//ListView
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));//GridView
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));//横向滑动GridView
        //mRecyclerView.setAdapter();
        adapter = new RecyclerViewAdapter(this,list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new LandingAnimator());
        mRecyclerView.getItemAnimator().setAddDuration(1000);
        mRecyclerView.getItemAnimator().setRemoveDuration(1000);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                list.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                adapter.notifyItemInserted(position);
            }
        });

    }


    private void init() {
        list = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }

    }


}
