package com.autobind.widget;

import android.view.View;

/**
 * Android中控件赋值方式不同，所以定义每个控件赋值方式的时候实现此接口 
 */
public interface IControlDataBinder {
	void setValue(View e,Object value,String format);
	Object getValue(View e);
}
