package com.android.app.mvp.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.app.dengzhaojun.R;
import com.android.app.dengzhaojun.activity.MainActivity;
import com.android.app.dengzhaojun.inspiring.adapter.MyAdapter;
import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;
import com.android.app.dengzhaojun.inspiring.utils.ItemConfig;
import com.android.app.dengzhaojun.inspiring.utils.ItemTouchHelperCallback;
import com.android.app.dengzhaojun.inspiring.utils.OnSlideListener;
import com.android.app.dengzhaojun.inspiring.utils.SlideLayoutManager;
import com.android.app.dengzhaojun.utils.MyDialog;
import com.android.app.mvp.TestAdapter;
import com.android.app.mvp.p.MvpPresenter;
import com.android.app.mylibrary.util.MLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */

public class MvpActivity extends Fragment implements MvpView {

    private MainActivity mContext;
    private MyDialog myDialog;
    private RecyclerView mRecyclerView;
    private TestAdapter myAdapter;
    private MvpPresenter mvpPresenter;

    private SlideLayoutManager mSlideLayoutManager;
    private ItemTouchHelper mItemTouchHelper;
    private ItemTouchHelperCallback mItemTouchHelperCallback;
    private List<Inspiring_Json.ShowapiResBodyBean.DataBean> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_two, container, false);
        initView(rootView);
//        initListener();
        return rootView;
    }

    private void initView(View rootView) {
        mContext = (MainActivity) getActivity();
        myDialog = new MyDialog(mContext);
        mRecyclerView = (rootView).findViewById(R.id.recycler_view);
        mvpPresenter = new MvpPresenter(this);
        //开始执行
        mvpPresenter.handledata();

//        if (mItemTouchHelperCallback != null) {
//        MLog.e("mItemTouchHelperCallback======>", "进入");
        mList = new ArrayList<>();
        mItemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerView.getAdapter(), mList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
        mSlideLayoutManager = new SlideLayoutManager(mRecyclerView, mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(mSlideLayoutManager);
//        }
    }


    private void initListener() {
        mItemTouchHelperCallback.setOnSlideListener(new OnSlideListener() {
            @Override
            public void onSliding(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                if (direction == ItemConfig.SLIDING_LEFT) {
                } else if (direction == ItemConfig.SLIDING_RIGHT) {
                }
            }

            @Override
            public void onSlided(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                if (direction == ItemConfig.SLIDED_LEFT) {
//                    mDislikeCount--;
//                    mSmileView.setDisLike(mDislikeCount);
//                    mSmileView.disLikeAnimation();
                } else if (direction == ItemConfig.SLIDED_RIGHT) {
//                    mLikeCount++;
//                    mSmileView.setLike(mLikeCount);
//                    mSmileView.likeAnimation();
                }
                int position = viewHolder.getAdapterPosition();
                MLog.e("------------------>", "onSlided--position:" + position);
            }

            @Override
            public void onClear() {
                mvpPresenter.handledata();
            }
        });
    }

    @Override
    public void showLoading() {
        myDialog.show();
    }

    @Override
    public void hideLoading() {
        myDialog.dismiss();
    }

    @Override
    public void setListItem(List<Inspiring_Json.ShowapiResBodyBean.DataBean> data) {
        MLog.e("mvd-------------->", data.size());
        myAdapter = new TestAdapter(mContext, data);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

//        mItemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerView.getAdapter(), mList);
//        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
//        mSlideLayoutManager = new SlideLayoutManager(mRecyclerView, mItemTouchHelper);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//        mRecyclerView.setLayoutManager(mSlideLayoutManager);
    }

    @Override
    public void failed() {
        Toast.makeText(mContext, "加载失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
