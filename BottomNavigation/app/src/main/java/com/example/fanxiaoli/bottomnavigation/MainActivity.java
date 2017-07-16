package com.example.fanxiaoli.bottomnavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TestRecycleViewAdapter adapter;

    //   private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.activity_main_recycle_view);

        //设置布局管理器
 //       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
 //       initData();
//        TestRecycleViewAdapter adapter = new TestRecycleViewAdapter(getApplicationContext(),list);
 //       mRecyclerView.setAdapter(adapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,5));
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        ArrayList<String>   list    =   new ArrayList<String>();
        for (int i = 0; i < 30; i++){
        list.add("item"+i);
        }
        adapter= new TestRecycleViewAdapter(getApplicationContext(),list);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    public boolean OnCreateOptionMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_add:
                adapter.addData(1);
                break;
            case R.id.menu_remove:
                adapter.RemoveData(1);
                break;
        }
        return true;
    }


}
