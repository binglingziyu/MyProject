package com.autobind.widget;

import android.view.View;

/**
 * Android�пؼ���ֵ��ʽ��ͬ�����Զ���ÿ���ؼ���ֵ��ʽ��ʱ��ʵ�ִ˽ӿ� 
 */
public interface IControlDataBinder {
	void setValue(View e,Object value,String format);
	Object getValue(View e);
}
