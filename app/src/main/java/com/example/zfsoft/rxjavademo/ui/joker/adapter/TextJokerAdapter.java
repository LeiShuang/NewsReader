package com.example.zfsoft.rxjavademo.ui.joker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zfsoft.rxjavademo.R;
import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2018/7/11 on 17:56
 * 描述:纯文本的笑话列表Adapter
 * 作者:Ls
 */
public class TextJokerAdapter extends RecyclerView.Adapter<TextJokerAdapter.MyViewHolder> {
    private List<TextNewsBean.ContentlistBean> lists;
    private Context mContext;
    private LayoutInflater mInflater;
    public TextJokerAdapter(Context context,List<TextNewsBean.ContentlistBean> lists) {
        mContext = context;
        this.lists = lists;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_text_joker,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(lists.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
                tv_title = (TextView)itemView.findViewById(R.id.tv_title_name);
        }
    }
}
