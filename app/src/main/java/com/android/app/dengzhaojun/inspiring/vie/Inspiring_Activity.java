package com.android.app.dengzhaojun.inspiring.vie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.app.dengzhaojun.inspiring.adapter.MyAdapter;
import com.android.app.dengzhaojun.utils.Constants;
import com.android.app.dengzhaojun.R;
import com.android.app.dengzhaojun.activity.MainActivity;
import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;
import com.android.app.dengzhaojun.inspiring.utils.ItemConfig;
import com.android.app.dengzhaojun.inspiring.utils.ItemTouchHelperCallback;
import com.android.app.dengzhaojun.inspiring.utils.OnSlideListener;
import com.android.app.dengzhaojun.inspiring.utils.RetrofitService;
import com.android.app.dengzhaojun.inspiring.utils.SlideLayoutManager;
import com.android.app.mylibrary.util.MLog;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Inspiring_Activity extends Fragment {
    private static final String TAG = "SlideFragment------->";
    private RecyclerView mRecyclerView;
    private SlideLayoutManager mSlideLayoutManager;
    private ItemTouchHelper mItemTouchHelper;
    private ItemTouchHelperCallback mItemTouchHelperCallback;
    private MyAdapter mAdapter;
    private List<Inspiring_Json.ShowapiResBodyBean.DataBean> mList = new ArrayList<>();
    private int mLikeCount = 50;
    private int mDislikeCount = 50;
    private MainActivity mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_two, container, false);
        mContext = (MainActivity) getActivity();
        initView(rootView);
        initListener();
        return rootView;
    }

    private void initView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        mAdapter = new MyAdapter(mContext,mList);
        mRecyclerView.setAdapter(mAdapter);
        addData();
        mItemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerView.getAdapter(), mList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
        mSlideLayoutManager = new SlideLayoutManager(mRecyclerView, mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(mSlideLayoutManager);

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
                    mDislikeCount--;
//                    mSmileView.setDisLike(mDislikeCount);
//                    mSmileView.disLikeAnimation();
                } else if (direction == ItemConfig.SLIDED_RIGHT) {
                    mLikeCount++;
//                    mSmileView.setLike(mLikeCount);
//                    mSmileView.likeAnimation();
                }
                int position = viewHolder.getAdapterPosition();
                MLog.e(TAG, "onSlided--position:" + position);
            }

            @Override
            public void onClear() {
                addData();
            }
        });
    }

    /**
     * 向集合中添加数据
     */
    private void addData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Inspiring_Json> call = service.getSearchBook(Constants.SHOWAPI_APPID,Constants.SHWAPI_SIGN,Constants.SHOWAPI_TIMESTAMP,Constants.COUNT);
        call.enqueue(new Callback<Inspiring_Json>() {
            @Override
            public void onResponse(Call<Inspiring_Json> call, Response<Inspiring_Json> response) {
                mList.addAll(response.body().getShowapi_res_body().getData());
                mAdapter.notifyDataSetChanged();
                MLog.e(TAG,mList.size());
            }

            @Override
            public void onFailure(Call<Inspiring_Json> call, Throwable t) {
                Toast.makeText(mContext, "系统错误", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 适配器
     */
//    class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.item_slide, parent, false);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            Inspiring_Json.ShowapiResBodyBean.DataBean bean = mList.get(position);
//            holder.imgBg.setImageResource(bean.getmUserIcon());
//            holder.tvTitle.setText(bean.getEnglish());
//            holder.userSay.setText(bean.getChinese());
//        }
//
//        @Override
//        public int getItemCount() {
//            return mList.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//
//            ImageView imgBg;
//            TextView tvTitle;
//            TextView userSay;
//
//            public ViewHolder(View itemView) {
//                super(itemView);
//                imgBg = itemView.findViewById(R.id.img_bg);
//                tvTitle = itemView.findViewById(R.id.english);
//                userSay = itemView.findViewById(R.id.chinese);
//            }
//        }
//    }
}
