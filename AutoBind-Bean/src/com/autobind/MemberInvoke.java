package com.autobind;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class MemberInvoke {
	
	public MemberInvoke(Class<?> type,String name)
	{
		try
		{
			mField = type.getField(name);
			mIsMethod= false;
			mInvalid = false;
		}
		catch(Exception e)
		{
			
		}
		if(mInvalid)
		{
			try
			{
				mGetMethod = type.getMethod("get"+name);
				mIsMethod= true;
				mInvalid = false;
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	private Field mField;
	
	private Method mGetMethod;
	
	private Boolean mInvalid= true;
	
	private Boolean mIsMethod = false;
	
	public Boolean GetInvalid()
	{
		return mInvalid;
	}
	
	public Object GetValue(Object target) throws Exception
	{
		if(!mInvalid)
		{
			if(mIsMethod)
			{
				return mGetMethod.invoke(target, null);
			}
			else
			{
				return mField.get(target);
			}
		}
		else
		{
			return null;
		}
	}
	 
}
