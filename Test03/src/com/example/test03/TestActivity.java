package com.example.test03;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.autobind.Binding;
import com.autobind.BindingFactory;
import com.autobind.ViewContent;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

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
		
//		String xml = "<?xml version='1.0' encoding='UTF-8'?>" +
//						"<content>" +
//							"<name type='string'>zhangsan</name>" +
//							"<sex type='string'>man</sex>" +
//							"<age type='int'>2</age>" +
//							"<edit1 type='string'>edit111</edit1>" +
//							"<edit2 type='string'>edit2222</edit2>" +
//							"<text3 type='string'>text3</text3>" +
//						"</content>";
//		Map<String,ViewContent> contents = new HashMap<String,ViewContent>();
//		List<ViewContent> contents = new ArrayList<ViewContent>();
		ViewContent[] contents = new ViewContent[11];
		for(int i=0;i<10;i++){
			ViewContent content = new ViewContent();
			content.setId("view"+i);
			content.setType("string");
			content.setValue("this is view "+i);
			content.setDesc("view"+i);
			
			contents[i] = content;
			//contents.add(content);
			//contents.put("view"+i,content);
		}
		ViewContent content = new ViewContent();
		content.setId("image");
		content.setType("Drawable");
		Drawable drawable = getResources().getDrawable(R.drawable.aaa);
		content.setValue(drawable);
		content.setDesc("image");
		
		contents[10] = content;
		//contents.add(content);
		
		binding = BindingFactory.getBinding("container1",view);
		binding.execute(contents);
		
		
	}


}
