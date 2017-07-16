package com.example.fanxiaoli.bottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestRecycleViewAdapter extends RecyclerView.Adapter<TestRecycleViewAdapter.ViewHolderA>
{
    private Context mContext;
    private List<String> mList;
    private List<Integer> mHeight;
    public TestRecycleViewAdapter(Context context,List<String> list)
    {
        mContext = context;
        mList = list;
        mHeight = new ArrayList<Integer>();
        for(int i=0;i<mList.size();i++)
        {
            mHeight.add((int)(80+Math.random()*300));
        }
    }

    @Override
    public TestRecycleViewAdapter.ViewHolderA onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item,parent,false);
        ViewHolderA holderA = new ViewHolderA(view);
        return holderA;
    }

    @Override
    public void onBindViewHolder(TestRecycleViewAdapter.ViewHolderA holder, final int position) {

        holder.mTextView.setText(mList.get(position));
        holder.mTextView.setVisibility(View.VISIBLE);
        ViewGroup.LayoutParams lp = holder.mTextView.getLayoutParams();
        lp.height = mHeight.get(position);

        holder.mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(mContext,"item"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolderA extends RecyclerView.ViewHolder
    {
        TextView mTextView;
        public ViewHolderA(View itemView)
        {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(R.id.recycle_textview);
        }
    }
    public void addData(int position)
    {
        mList.add(position,"新增"+position);
        notifyItemInserted(position);

    }
    public void RemoveData(int position)
    {
        mList.remove(position);
        notifyItemRemoved(position);
    }
}