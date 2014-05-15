package com.autobind;

import android.view.View;

public interface IControlDataBinder {
	void setValue(View e,Object value,String format);
	Object getValue(View e);
}
