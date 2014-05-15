package com.autobind.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.autobind.IControlDataBinder;
import com.example.test03.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class ImageViewDataBinder implements IControlDataBinder {
	DisplayImageOptions options;
	ImageLoader imageLoader = ImageLoader.getInstance();
	
	@Override
	public void setValue(View e, Object value, String format) {
		ImageView control = (ImageView) e;
		
		if (value instanceof Drawable) {
			control.setImageDrawable((Drawable) value);
		} else if (value instanceof Bitmap) {
			control.setImageBitmap((Bitmap) value);
		} else if (value instanceof Integer) {
			control.setImageResource((Integer) value);
		}else if(value instanceof String){
			//imageLoader.init(configuration)
		}

	}
	
	/**
	 * 图片加载过程的配置
	 */
//	private void initLoader(){
//		
//		options = new DisplayImageOptions.Builder()
//		.showImageForEmptyUri(R.drawable.ic_launcher)
//		.cacheOnDisc()
//		.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
//		.displayer(new RoundedBitmapDisplayer(30))
//		.build();
//	}

	@Override
	public Object getValue(View e) {

		return null;
	}

}
