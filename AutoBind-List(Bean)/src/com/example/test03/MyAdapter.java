package com.example.test03;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autobind.BindingFactory;
import com.autobind.bind.Binding;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private List<Person> list;
	
	
	
	public MyAdapter(Context mContext, List<Person> list) {
		super();
		this.mContext = mContext;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder holder = null;
		if(arg1 == null){
			arg1 = View.inflate(mContext, R.layout.list_item, null);
			holder = new ViewHolder();

			ViewUtils.inject(holder,arg1);
			
			arg1.setTag(holder);
			
		}else{
			holder = (ViewHolder) arg1.getTag();
		}
		Binding binding = BindingFactory.getBinding("listitem", holder);
//		binding.Execute(holder,list.get(arg0));
		
		return arg1;
	}
	static class ViewHolder{
		@ViewInject(R.id.text)
		TextView text;
		@ViewInject(R.id.edit1)
		TextView edit;
		@ViewInject(R.id.edit2)
		TextView edit2;
		@ViewInject(R.id.image)
		ImageView image;
	}

}
