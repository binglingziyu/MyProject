package com.autobind;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * 绑定器
 *
 */
public class Binding {

	private Map<String,ControlHandler> mControls = new HashMap<String,ControlHandler>();
	private Map<String,Integer> mIDs = new HashMap<String, Integer>();
	/** ViewHolder绑定器用到的Map */
	private Map<String,View> mView;
	
	/** 用于标记绑定的对象是View？Activity？ViewHolder？ */
	private String bind_what;
	private View view;
	private Activity activity;
	private Object holder;

	public Binding(View view) {
		bind_what = "view";
		this.view = view;
		findChild(view);
	}

	public Binding(Activity activity) {
		bind_what = "activity";
		this.activity = activity;
		findChild(activity.findViewById(android.R.id.content));
	}

	public Binding(Object holder) {
		bind_what = "holder";
		this.holder = holder;
		mView = new HashMap<String,View>();
		findChild(holder);
	}

	/**
	 * 从View中遍历所包含的控件
	 * @param view
	 */
	private void findChild(View view) {
		ViewGroup bg = null;
		View nextChild = null;

		if (view instanceof ViewGroup)
			bg = (ViewGroup) view;
		if (bg != null) {
			for (int i = 0; i < bg.getChildCount(); ++i) {
				nextChild = bg.getChildAt(i);
				if (nextChild instanceof ViewGroup) {
					findChild(nextChild);
				} else {

					CharSequence cs = nextChild.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = nextChild.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						String member = bindinfo.split(":")[1];
						mIDs.put(member, nextChild.getId());
						mControls
								.put(member,new ControlHandler(
												nextChild.getClass(), member));
					}
				}

			}
		}
	}

	/**
	 * 从ViewHolder中反射出所含控件
	 * @param object    ViewHolder
	 */
	private void findChild(Object object) {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(object);
				if (obj instanceof View) {
					View view = (View) obj;
					CharSequence cs = view.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = view.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						String member = bindinfo.split(":")[1];
						mIDs.put(member, view.getId());
						mControls.put(member,new ControlHandler(view.getClass(), member));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
	
	/**
	 * 绑定数据
	 * @param contents
	 */
	public void  execute(Map<String, ViewContent> contents) {
		if (bind_what.equals("view")) {
			try {
				Iterator<String> iterator = contents.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next();
					ViewContent value = contents.get(key);
					mControls.get(key).ToControl(view.findViewById(mIDs.get(key)), value);
				}
				
//				for (Control item : mControls) {
//					IViewContent content = contents.get(item.Handler
//							.getmMemberName());
//					item.Handler.ToControl(view.findViewById(item.ID), content);
//				}
			} catch (Exception e) {

			}
		} else if (bind_what.equals("activity")) {
			try {
				Iterator<String> iterator = contents.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next();
					ViewContent value = contents.get(key);
					mControls.get(key).ToControl(activity.findViewById(mIDs.get(key)), value);
				}
//				for (Control item : mControls) {
//					IViewContent content = contents.get(item.Handler
//							.getmMemberName());
//					item.Handler.ToControl(activity.findViewById(item.ID),
//							content);
//				}
			} catch (Exception e) {

			}
		} else if (bind_what.equals("holder")) {
			try {
				Iterator<String> iterator = contents.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next();
					ViewContent value = contents.get(key);
					findFields(holder);
					mControls.get(key).ToControl(mView.get(key), value);
				}
//				for (int i = 0; i < mControls.size(); i++) {
//					Control item = mControls.get(i);
//					findFields(holder);
//					IViewContent content = contents.get(item.Handler
//							.getmMemberName());
//					item.Handler.ToControl(mView.get(i), content);
//				}
			} catch (Exception e) {

			}
		}
	}
	
	/**
	 * 绑定数据
	 * @param contents
	 */
	public void  execute(List<ViewContent> contents) {
		Map<String, ViewContent> map = new HashMap<String, ViewContent>();
		for(ViewContent content:contents){
			String key = content.getId();
			map.put(key, content);
		}
		execute(map);
	}
	
	/**
	 * 绑定数据
	 * @param t
	 */
	public void execute(ViewContent[] contents){
		Map<String, ViewContent> map = new HashMap<String, ViewContent>();
		for(ViewContent item:contents){
			String key = item.getId();
			map.put(key, item);
		}
		execute(map);
	}

	/**
	 * 给View绑定数据
	 * 
	 * @param view
	 * @param object
	 */
	// public void execute(View view, Map<String,ViewContent> contents) {
	// try {
	// for (Control item : mControls) {
	// ViewContent content = contents.get(item.Handler.getmMemberName());
	// item.Handler.ToControl(view.findViewById(item.ID), content);
	// }
	// } catch (Exception e) {
	//
	// }
	// }

	/**
	 * 给Activity绑定数据
	 * 
	 * @param activity
	 * @param xml
	 */
	// public void execute(Activity activity, Map<String,ViewContent> contents){
	// execute(activity.findViewById(android.R.id.content),contents);
	// }

	/**
	 * 给ViewHolder绑定数据
	 * 
	 * @param object
	 * @param xml
	 */
	// public void execute(Object holder,Map<String,ViewContent> contents){
	// try {
	// for(int i=0;i<mControls.size();i++){
	// Control item = mControls.get(i);
	// findFields(holder);
	// ViewContent content = contents.get(item.Handler.getmMemberName());
	// item.Handler.ToControl(mView.get(i), content);
	// }
	// } catch (Exception e) {
	//
	// }
	// }

	/**
	 * 从ViewHolder中反射出所包含的控件
	 * 
	 * @param object
	 *            ViewHolder
	 */
	public void findFields(Object object) {
		mView.clear();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(object);
				if (obj instanceof View) {
					View view = (View) obj;
					CharSequence cs = view.getContentDescription();
					String bindinfo = null;
					if (cs != null)
						bindinfo = view.getContentDescription().toString();
					if (bindinfo != null && bindinfo.indexOf("bind:") == 0) {
						String member = bindinfo.split(":")[1];
						mView.put(member,view);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 下面三个set方法用于在BindingFactory中更新Binding绑定的对象
	public void setView(View view) {
		this.view = view;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setHolder(Object holder) {
		this.holder = holder;
	}

}
