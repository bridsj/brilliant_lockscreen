package com.brilliant.lockscreen;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.brilliant.lockscreen.ui.view.gooleprogressbar.GoogleProgressBar;
import com.brilliant.lockscreen.ui.view.parallax.ObservableScrollView;
import com.brilliant.lockscreen.ui.view.parallax.ParallaxScrollView;
import com.brixd.android.utils.device.PhoneUtil;

/**
 * @author deng.shengjin
 * @version create_time:2014-12-7 上午11:43:05
 * @Description 个人信息界面
 */
public class PersonalActivity extends BaseActivity {
	private ParallaxScrollView mScrollView;
	private ObservableScrollView observableScrollView;
	private GoogleProgressBar mProgressBar;

	@Override
	protected void initData() {

	}

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_personal);
		mScrollView = (ParallaxScrollView) findViewById(R.id.scroll_view);
		observableScrollView = (ObservableScrollView) findViewById(R.id.observable_scroll_view);
		mProgressBar = (GoogleProgressBar) findViewById(R.id.google_progress);
		float offset = mScrollView.getParallaxOffset();
		offset = offset + 0.05f;
		mScrollView.setParallaxOffset(offset);
		Rect bounds = mProgressBar.getIndeterminateDrawable().getBounds();
		mProgressBar.getIndeterminateDrawable().setBounds(bounds);
		mProgressBar.setIndeterminate(false);
	}

	@Override
	protected void initActions() {
		mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onGlobalLayout() {
				mScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				final ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) observableScrollView.getLayoutParams();
				lp.width = PhoneUtil.getDisplayWidth(getApplicationContext());
				observableScrollView.requestLayout();
			}
		});
	}

}
