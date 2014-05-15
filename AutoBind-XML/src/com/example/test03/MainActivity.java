package com.example.test03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
		
		
		Person person  = new Person();
		person.setText2("你好");
		person.setText3("你好");
		person.setText4("你好");
		person.setText5("你好");
		person.setText6("你好");
		person.setText7("你好");
		person.setText8("你好");
		person.setText9("你好");
		person.setText10("你好");
		person.setText11("你好");
		person.setText12("你好");
		person.setText13("你好");
		person.setText14("你好");
		person.setText15("你好");
		person.setText16("你好");
		person.setText17("你好");
		person.setText18("你好");
		person.setText19("你好");
		person.setText20("你好");
		person.setText21("你好");
		person.setText22("你好");
		person.setText23("你好");
		person.setText24("你好");
		person.setText25("你好");
		person.setText26("你好");
		person.setText27("你好");
		person.setText28("你好");
		person.setText29("你好");
		person.setText30("你好");
		person.setText31("你好");
		person.setText32("你好");
		person.setText33("你好");
		person.setText34("你好");
		person.setEdit("hello");
		binding = BindingFactory.getBindig("main", this);
		
//		binding.Execute(this, person);
		
	}
	
	@OnClick(R.id.button)
	public void click(View view){
		Intent intent = new Intent(this,
				ListViewActivity.class);
		startActivity(intent);
	}

}
