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
			Toast.makeText(this, "��һ��TextView", 0).show();
			mytext.setText("��ֻ��Ʊ���ƺܺð���");
		}else {
			Toast.makeText(this, "����TextView", 0).show();
		}
		
		
		Person person  = new Person();
		person.setText2("���");
		person.setText3("���");
		person.setText4("���");
		person.setText5("���");
		person.setText6("���");
		person.setText7("���");
		person.setText8("���");
		person.setText9("���");
		person.setText10("���");
		person.setText11("���");
		person.setText12("���");
		person.setText13("���");
		person.setText14("���");
		person.setText15("���");
		person.setText16("���");
		person.setText17("���");
		person.setText18("���");
		person.setText19("���");
		person.setText20("���");
		person.setText21("���");
		person.setText22("���");
		person.setText23("���");
		person.setText24("���");
		person.setText25("���");
		person.setText26("���");
		person.setText27("���");
		person.setText28("���");
		person.setText29("���");
		person.setText30("���");
		person.setText31("���");
		person.setText32("���");
		person.setText33("���");
		person.setText34("���");
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
