package com.autobind.widget;

import com.autobind.IControlDataBinder;

import android.view.View;
import android.widget.TextView;

public class TextViewDataBinder implements IControlDataBinder {

	@Override
	public void setValue(View e, Object value, String format) {
		TextView control = (TextView) e;

		if (value instanceof String) {
			control.setText(value.toString());
		} else if (value instanceof Integer) {
			control.setText((Integer) value);
		}

	}

	@Override
	public Object getValue(View e) {
		TextView control = (TextView) e;
		return control.getText().toString();
	}

}
