package com.autobind;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.autobind.widget.EditTextDataBinder;
import com.autobind.widget.ImageViewDataBinder;
import com.autobind.widget.TextViewDataBinder;

public class ControlHandler {
	
	public ControlHandler(Class<?> view,String membername)
	{
		mMemberName=membername;
		
		if(view.equals(TextView.class))
		{
			mDataBinder = new TextViewDataBinder();
		}
		else if(view.equals(EditText.class))
		{
			mDataBinder = new EditTextDataBinder();
		}
		else if(view.equals(ImageView.class))
		{
			mDataBinder = new ImageViewDataBinder();

		}
	}
	
//	private HashMap<Class<?>, MemberInvoke> mMemberInvokeTbl = new HashMap<Class<?>, MemberInvoke>();
	
	private String mMemberName;
		
	private IControlDataBinder mDataBinder;
	
    public void ToControl(View view,IViewContent content) throws Exception
    {
    	//MemberInvoke mi = GetMemberInvoke(source.getClass());
    	//if(!mi.GetInvalid())
    	//{
    	//}
    	mDataBinder.setValue(view, content.getValue(), null);
    }
    
//    private MemberInvoke GetMemberInvoke(Class<?> type)
//    {
//    	MemberInvoke result= mMemberInvokeTbl.get(type);
//    	if(result ==null)
//    	{
//    		result = new MemberInvoke(type, mMemberName);
//    		mMemberInvokeTbl.put(type, result);
//    	}
//    	return result;
//    }

	public String getmMemberName() {
		return mMemberName;
	}
    
    
	
}
