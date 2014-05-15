package com.autobind;

import java.util.HashMap;

import android.app.Activity;
import android.view.View;

public class BindingFactory {
	/** 用来存储绑定器 */
	private static HashMap<String, Binding> mBindingTbl = new HashMap<String, Binding>();
	/**
	 * 获取View的绑定器
	 * @param name  绑定器名称
	 * @param view
	 * @return
	 */
	public static Binding getBinding(String name,View view)
	{
		Binding result = null;
		result = mBindingTbl.get(name);
		if(result ==null)
		{
			result = new Binding(view);
			mBindingTbl.put(name, result);
		}
		return result;
	}
	
	/**
	 * 获取ViewHolder的绑定器
	 * @param name   绑定器名称
	 * @param object
	 * @return
	 */
	public static Binding getBindig(String name,Object object)
	{
		Binding result = null;
		result = mBindingTbl.get(name);
		if(result ==null)
		{
			result = new Binding(object);
			mBindingTbl.put(name, result);
		}
		return result;
	}
	
	/**
	 * 获取Activity的绑定器
	 * @param name    绑定器名称
	 * @param activity
	 * @return
	 */
	public static Binding getBindig(String name,Activity activity)
	{
		Binding result = null;
		result = mBindingTbl.get(name);
		if(result ==null)
		{
			result = new Binding(activity);
			mBindingTbl.put(name, result);
		}
		return result;
	}
	
	
}
