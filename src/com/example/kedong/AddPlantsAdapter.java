package com.example.kedong;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AddPlantsAdapter extends BaseAdapter {
	//item上显示的String文本
	private ArrayList<String> items;
	//指示对应的条目是否被选中
	private ArrayList<Boolean> isChice;
	private Context context;
	
	public AddPlantsAdapter(ArrayList im, Context context) {
		this.items = im;
		Log.i("hck", im.size()+"lenght");
		isChice=new ArrayList<Boolean>();
		
		for (int i = 0; i < im.size(); i++) {
			isChice.add(i, false);
		}
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}
	
	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}
	
	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View view = arg1;
		if (view == null) {
			ViewGroup viewGroup = (ViewGroup)LayoutInflater.from(context).inflate(R.layout.add_plants_gridview_item, null);

			TextView textView = (TextView)viewGroup.findViewById(R.id.textViewInItem);
			textView.setText(items.get(arg0));
			view = viewGroup;
		} else {
			TextView textView = (TextView)view.findViewById(R.id.textViewInItem);
			textView.setText(items.get(arg0));
		}
		
		if((arg0 ==(items.size()-1))
				&&
				!isEditState())
		{
			ViewGroup viewGroup1 = (ViewGroup)view.findViewById(R.id.gridViewitem);
			viewGroup1.setBackgroundResource(R.drawable.add_icon);
		}
		else
		{
			ViewGroup viewGroup1 = (ViewGroup)view.findViewById(R.id.gridViewitem);
			viewGroup1.setBackgroundResource(R.drawable.frame_rectangle_black9patch);
		}
		if(isChice.get(arg0))
		{
			ImageView imageView = (ImageView)view.findViewById(R.id.imageViewInItem);
			imageView.setVisibility(View.VISIBLE);
		}
		else
		{
			ImageView imageView = (ImageView)view.findViewById(R.id.imageViewInItem);
			imageView.setVisibility(View.GONE);
		}


		return view;
	}

	public void chiceState(int post)
	{
		isChice.set(post,isChice.get(post)==true?false:true);
		this.notifyDataSetChanged();
	}
	
	public void deletItem(int post)
	{
		if(isChice.get(post))
		{
			items.remove(post);
			this.notifyDataSetChanged();
		}

	}
	//全选，使全部条目选中，出现叉号
	public void editAll()
	{
		for(int i=0; i<items.size()-1; i++)
		{
			isChice.set(i,true);
			
		}
		if(items.get(items.size()-1) == "")
			items.remove(items.size()-1);
		this.notifyDataSetChanged();
	}
	
	//全选，使全部条目选中，出现叉号
	public void cancelEditAll()
	{
		if(!isHaveAddButton())
			items.add("");
		for(int i=0; i<items.size(); i++)
		{
			isChice.set(i,false);		
		}

		this.notifyDataSetChanged();
	}
	
	private boolean isHaveAddButton()
	{
		if(items.get(items.size()-1) == "")
			return true;
		else
			return false;
	}
	
	public void addPlant(String str)
	{
		if(!items.contains(str)){
			items.add(items.size()-1, str);
			isChice.add(items.size()-1, false);
			this.notifyDataSetChanged();
		}

	}
	
	public boolean isAddButton(int position)
	{
		if(items.get(position) == "")
			return true;
		else
			return false;
	}
	private boolean isEditState()
	{
		for(int i=0; i<items.size(); i++)
		{
			if(isChice.get(i))
				continue;
			else
			{
				return false;
			}
		}
		return true;
	}

}