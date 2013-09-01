package com.sokolovskiy.ukrbasketsuperleague;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	Context context;
    private int[] images = new int[] {
        R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
        R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,
        R.drawable.photo7,R.drawable.photo8,R.drawable.photo9
    };
    ImageAdapter(Context context){
    	this.context=context;
    }
    @Override
    public int getCount() {
      return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      ImageView imageView = new ImageView(context);
      int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageResource(images[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((ImageView) object);
    }
  }
