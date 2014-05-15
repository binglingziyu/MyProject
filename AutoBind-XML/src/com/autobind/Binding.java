package com.autobind;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public class Binding {
	
	private ArrayList<Control> mControls = new ArrayList<Control>();
	/** ViewHolder绑定器用到的List */
	private ArrayList<View> mView;
	
	public Binding(View view) {
		findChild(view);
	}
	public Binding(Object object) {
		mView = new ArrayList<View>();
		findChild(object);
	}
	public Binding(Activity activity) {
		findChild(activity.findViewById(android.R.id.content));
	}
	
	/**
	 * 从View对象中遍历所包含的控件
	 * @param view
	 */
	private void findChild(View view) {
		ViewGroup bg = null;
		View nextChild = null;

		if (view instanceof ViewGroup)
			bg = (ViewGroup) view;
		if (bg != null) {
			for (int i = 0; i < bg.getChildCount(); ++i) {
				nextChild = bg.getChildAt(i);
				if (nextChild instanceof ViewGroup) {
					findChild(nextChild);
				} else {

					CharSequence cs = nextChild.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = nextChild.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						String member = bindinfo.split(":")[1];
						mControls
								.add(new Control(nextChild.getId(),
										new ControlHandler(
												nextChild.getClass(), member)));
					}
				}

			}
		}
	}
	
	/**
	 * 从ViewHolder中反射出所含控件
	 * @param object   ViewHolder
	 */
	private void findChild(Object object) {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(object);
				if (obj instanceof View) {
					View view = (View) obj;
					CharSequence cs = view.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = view.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						String member = bindinfo.split(":")[1];
						mControls.add(new Control(view.getId(),
								new ControlHandler(view.getClass(), member)));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 给View绑定数据
	 * @param view
	 * @param xml
	 */
	public void Execute(View view, String xml) {
		try {
			for (Control item : mControls) {
				item.Handler.ToControl(view.findViewById(item.ID), xml);
			}
		} catch (Exception e) {

		}
	}
	
	/**
	 * 给Activity绑定数据
	 * @param activity
	 * @param xml
	 */
	public void Execute(Activity activity, String xml){
		Execute(activity.findViewById(android.R.id.content),xml);
	}
	
	/**
	 * 给ViewHolder绑定数据
	 * @param object
	 * @param xml
	 */
	public void Execute(Object object,String xml){
		try {
			for(int i=0;i<mControls.size();i++){
				Control item = mControls.get(i);
				findFields(object);
				item.Handler.ToControl(mView.get(i), xml);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 从ViewHolder中反射出所包含的控件
	 * @param object   ViewHolder
	 */
	public void findFields(Object object){
		mView.clear();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(object);
				if (obj instanceof View) {
					View view = (View) obj;
					CharSequence cs = view.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = view.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						mView.add(view);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
