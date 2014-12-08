package com.brilliant.lockscreen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author deng.shengjin
 * @version create_time:2014-12-7 上午11:46:11
 * @Description 父类
 */
public abstract class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		initData();
		initViews();
		initActions();
	}

	protected abstract void initData();

	protected abstract void initViews();

	protected abstract void initActions();

}
