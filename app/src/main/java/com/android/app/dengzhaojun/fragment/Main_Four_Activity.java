package com.android.app.dengzhaojun.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.dengzhaojun.R;
import com.android.app.dengzhaojun.activity.MainActivity;


public class Main_Four_Activity extends Fragment {
	
	private MainActivity mContext;
	private View mView;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mView == null) {
			mContext = (MainActivity) getActivity();
			mView = inflater.inflate(R.layout.activity_four, null);
			init();
		}
		ViewGroup group = (ViewGroup) mView.getParent();
		if (group != null) {
			group.removeView(mView);
		}
		return mView;
	}
	
	private void init() {
	}
	

}
