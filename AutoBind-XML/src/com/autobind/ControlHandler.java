package com.autobind;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
	
	private String mMemberName;
	
	private IControlDataBinder mDataBinder;
	
    public void ToControl(View view,String xml) throws Exception
    {
    
    
    		Object msg = getValue(xml);
    	    mDataBinder.setValue(view, msg, null);
    
    }
    
    private Object getValue(String xml){
    	Document document = null;
		try {
			document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Element element = root.element(mMemberName);
//			String type = element.attribute("type").getValue();
//			if(type.equals("int")){
//				return Integer.valueOf(element.getTextTrim());
//			}
			return element.getTextTrim();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
