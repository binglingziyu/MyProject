package com.autobind;

import java.util.HashMap;

import android.app.Activity;
import android.view.View;

public class BindingFactory {
	/** �����洢���� */
	private static HashMap<String, Binding> mBindingTbl = new HashMap<String, Binding>();
	/**
	 * ��ȡView�İ���
	 * @param name  ��������
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
	 * ��ȡViewHolder�İ���
	 * @param name   ��������
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
	 * ��ȡActivity�İ���
	 * @param name    ��������
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
