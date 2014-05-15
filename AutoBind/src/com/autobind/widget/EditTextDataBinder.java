package com.autobind.widget;

import com.autobind.IControlDataBinder;

import android.view.View;
import android.widget.EditText;

public class EditTextDataBinder implements IControlDataBinder {

	@Override
	public void setValue(View e, Object value, String format) {
		EditText control = (EditText) e;

		if (value instanceof String) {
			control.setText(value.toString());
		} else if (value instanceof Integer) {
			control.setText((Integer) value);
		}

	}

	@Override
	public Object getValue(View e) {
		EditText control = (EditText) e;
		return control.getText().toString();
	}

}
