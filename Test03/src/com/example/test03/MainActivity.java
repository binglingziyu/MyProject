package com.example.test03;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.autobind.Binding;
import com.autobind.BindingFactory;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends Activity{
	
	private Binding binding;
	
	@ViewInject(R.id.mytext)
	private MyTextView mytext;
	
	@ViewInject(R.id.button)
	private Button button;
	@ViewInject(R.id.refresh)
	private Button refresh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//View view = View.inflate(this, ,null);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
		
		if(mytext instanceof TextView){
			Toast.makeText(this, "是一个TextView", 0).show();
			mytext.setText("这只股票涨势很好啊！");
		}else {
			Toast.makeText(this, "不是TextView", 0).show();
		}
		
		
		List<ViewContent> list = new ArrayList<ViewContent>();
		
		for(int i=1;i<=34;i++){
			ViewContent content = new ViewContent();
			content.setId("Text"+i);
			content.setType("string");
			content.setValue("this is text "+i);
			content.setDesc("just for test");
			
			list.add(content);
		}
		ViewContent content = new ViewContent();
		content.setId("Edit");
		content.setType("string");
		content.setValue("this is edit ");
		content.setDesc("just for test");
		
		list.add(content);
		binding = BindingFactory.getBinding("main", this);
		
		binding.execute(list);
		
	}
	
	@OnClick(R.id.button)
	public void click(View view){
		Intent intent = new Intent(this,
				TestActivity.class);
		startActivity(intent);
	}
	
	@OnClick(R.id.refresh)
	public void refresh(View view){
		finish();  
		Intent intent = new Intent(MainActivity.this, MainActivity.class);  
		startActivity(intent); 

	}
	

}
