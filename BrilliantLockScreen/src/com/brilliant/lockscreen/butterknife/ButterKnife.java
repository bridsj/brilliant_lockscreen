package com.brilliant.lockscreen.butterknife;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;

/**
 * @author deng.shengjin
 * @version update_time:2014-12-7 下午6:34:10
 * @Description TODO
 * @see https://github.com/JakeWharton/butterknife
 */
public final class ButterKnife {
	public static void inject(Activity activity) {
		injectContentView(activity);
		injectViews(activity);
	}

	private static void injectContentView(Activity activity) {
		Class<? extends Activity> clazz = activity.getClass();
		// 查询类上是否存在ContentView注解
		ContentView contentView = clazz.getAnnotation(ContentView.class);
		if (contentView != null)// 存在
		{
			int contentViewLayoutId = contentView.value();
			try {
				Method method = clazz.getMethod("setContentView", int.class);
				method.setAccessible(true);
				method.invoke(activity, contentViewLayoutId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void injectViews(Activity activity) {
		Class<? extends Activity> clazz = activity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		// 遍历所有成员变量
		for (Field field : fields) {
			InjectView viewInjectAnnotation = field.getAnnotation(InjectView.class);
			if (viewInjectAnnotation != null) {
				int viewId = viewInjectAnnotation.value();
				if (viewId != -1) {
					// 初始化View
					try {
						Method method = clazz.getMethod("findViewById", int.class);
						Object resView = method.invoke(activity, viewId);
						field.setAccessible(true);
						field.set(activity, resView);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}

		}

	}
}
