package com.example.test03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.autobind.Binding;
import com.autobind.BindingFactory;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.ImageLoader;

public class TestActivity extends Activity {

	@ViewInject(R.id.container1)
	private LinearLayout ll1;
	
	private Binding binding;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View view = View.inflate(this, R.layout.activity_test, null);
		setContentView(view);
		
		ViewUtils.inject(this);
		
		String xml = "<?xml version='1.0' encoding='UTF-8'?>" +
						"<content>" +
							"<name type='string'>zhangsan</name>" +
							"<sex type='string'>man</sex>" +
							"<age type='int'>2</age>" +
							"<edit1 type='string'>edit111</edit1>" +
							"<edit2 type='string'>edit2222</edit2>" +
							"<text3 type='string'>text3</text3>" +
						"</content>";
		
		binding = BindingFactory.getBinding("container1",ll1);
		binding.Execute(ll1, xml);
				
	}


}
