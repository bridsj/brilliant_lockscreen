package com.brilliant.lockscreen.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * @author deng.shengjin
 * @version create_time:2014-12-7 下午6:40:49
 * @Description TODO
 */
public class CacheDBUtil {
	private Context mContext;
	private static CacheDBUtil cacheDBUtil;
	private SharedPreferences mSharedPreferences;

	private CacheDBUtil(Context context) {
		super();
		this.mContext = context;
		mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
	}

	public static CacheDBUtil getInstance(Context context) {
		if (cacheDBUtil == null) {
			cacheDBUtil = new CacheDBUtil(context);
		}
		return cacheDBUtil;
	}

	public void saveDB(Context mContext, String key, String value) {
		Editor editor = mSharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
}
