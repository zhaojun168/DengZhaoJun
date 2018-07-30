package com.android.app.dengzhaojun.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.dengzhaojun.R;
import com.android.app.dengzhaojun.activity.MainActivity;
import com.umeng.analytics.MobclickAgent;


public class Main_Two_Activity  extends Fragment {
	
	private MainActivity mContext;
	private View mView;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mView == null) {
			mContext = (MainActivity) getActivity();
			mView = inflater.inflate(R.layout.activity_two, null);
		}
		ViewGroup group = (ViewGroup) mView.getParent();
		if (group != null) {
			group.removeView(mView);
		}
		return mView;
	}

	@Override
	public void onResume() {
		super.onResume();
		MobclickAgent.onResume(mContext);
		MobclickAgent.onPageStart("Main_One_Activity");
	}

	@Override
	public void onPause() {
		super.onPause();
		MobclickAgent.onPause(mContext);
		MobclickAgent.onPageEnd("Main_One_Activity");
	}
	

}
