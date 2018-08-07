package com.android.app.dengzhaojun.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

import com.android.app.dengzhaojun.R;


public class MyDialog extends Dialog {
	
	private ImageView mImageView;
	private AnimationDrawable mAnimation;

	public MyDialog(Context context) {
		super(context, R.style.Dialog);
		setContentView(R.layout.dialog);
		initView();
		setCanceledOnTouchOutside(false);//当Dialog显示时，禁止点击
	}
	
	
	private void initView() {
		mImageView = (ImageView) findViewById(R.id.loadingIv);
		mImageView.setBackgroundResource(R.drawable.dialog);
		// 通过ImageView对象拿到背景显示的AnimationDrawable
		mAnimation = (AnimationDrawable) mImageView.getBackground();
		// 为了防止在onCreate方法中只显示第一帧的解决方案之一
		mImageView.post(new Runnable() {
			@Override
			public void run() {
				mAnimation.start();
			}
		});
	}
}
