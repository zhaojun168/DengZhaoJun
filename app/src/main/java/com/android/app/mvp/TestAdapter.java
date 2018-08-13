package com.android.app.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.app.dengzhaojun.R;
import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;
import com.android.app.mylibrary.util.MLog;

import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private Context mContext;
    private List<Inspiring_Json.ShowapiResBodyBean.DataBean> mList;

    public TestAdapter(Context context, List<Inspiring_Json.ShowapiResBodyBean.DataBean> list){
        this.mContext = context;
        this.mList = list;
        MLog.e("TestAdapter--------->",mList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_slide, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Inspiring_Json.ShowapiResBodyBean.DataBean bean = mList.get(position);
        holder.tvEnglish.setText(bean.getEnglish());
        holder.tvChinese.setText(bean.getChinese());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvEnglish;
        TextView tvChinese;
        public ViewHolder(View itemView) {
            super(itemView);
            tvEnglish = itemView.findViewById(R.id.english);
            tvChinese = itemView.findViewById(R.id.chinese);
        }
    }
}
