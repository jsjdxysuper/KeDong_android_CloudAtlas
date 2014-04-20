package com.example.kedong;
import java.util.ArrayList;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
/*FragmentActivity与Activity确实没有太多的使用上的区别，只不过要注意，在使用时，
 * 如果要使用FragmentActivity则全部的 引用包全部使用android.support.v4.app下的类
 * 如果使用Activity，则相关的类要全部使用android.app下的类*/
/*
 * 1.View是ViewGroup的父类，能够用方法得到View类的地方，可以强制类型转化为ViewGroup类
 * 2.ViewPager，Adapter之间的关系，ViewPager提供视图层，Adapter提供数据，Activity类似于控制层
 * 3.*/
public class PlantsActivity extends FragmentActivity {

	private Fragment[] mFragments;
	private RadioGroup bottomRg;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private RadioButton rbPlants, rbUnits, rbCurves, rbStandard, rbSet;
	private ViewGroup main;
	
	
    private ViewPager mPager;
	private ArrayList<View> pageViewsList;
    //包裹小圆点的图片视图组
    private ViewGroup pointViewGroup;
    private ImageView[] imageViews;
    private ImageView imageView;
    private int fragmentCout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		LayoutInflater inflater = getLayoutInflater();
		main = (ViewGroup)inflater.inflate(R.layout.fragment_plants, null);
		
		
		setContentView(R.layout.plants);
       

		
		mFragments = new Fragment[5];
		fragmentManager = getSupportFragmentManager();
		mFragments[0] = fragmentManager
				.findFragmentById(R.id.fragement_plants);
		//如果把这部分与添加Fragment分开的话，添加的是fragment_plants的静态页面，将会什么都没有
		//因为ViewPager页面的实现是动态的，仅仅使用xml添加时不能实现动态效果的
		//也没有想到，Fragment类用getView方法可以获得其ViewGroup类，这样以后就可以这样使用了
		main = (ViewGroup)mFragments[0].getView();	
		
		
		mPager = (ViewPager) main.findViewById(R.id.plantsFragmentViewPager);
		
		pageViewsList = new ArrayList<View>();
      
		pageViewsList.add(inflater.inflate(R.layout.fragment_oneplant, null));
		pageViewsList.add(inflater.inflate(R.layout.fragment_oneplant, null));
		pageViewsList.add(inflater.inflate(R.layout.fragment_oneplant, null));
		pageViewsList.add(inflater.inflate(R.layout.fragment_oneplant, null));	
		
      
      
		pointViewGroup = (ViewGroup)main.findViewById(R.id.pointsViewGroup);
		imageViews = new ImageView[pageViewsList.size()];
		for(int i=0; i<pageViewsList.size(); i++){
			imageView = new ImageView(this);//能不能换成this

			if(imageView == null)return;
			imageView.setLayoutParams(new LayoutParams(20,20));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i] = imageView;
			
			if( i == 0){
				imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
			}else{
				imageViews[i].setBackgroundResource(R.drawable.page_indicator);
			}
			
			pointViewGroup.addView(imageViews[i]);
		}
		
		mPager.setOnPageChangeListener(new MyPageChangeListener());
	    mPager.setAdapter(new GuidePageAdapter());
	        
	        
	        
	        
		
		mFragments[1] = fragmentManager
				.findFragmentById(R.id.fragement_uints);
		mFragments[2] = fragmentManager
				.findFragmentById(R.id.fragement_curves);
		mFragments[3] = fragmentManager
				.findFragmentById(R.id.fragement_standard);
		mFragments[4] = fragmentManager
				.findFragmentById(R.id.fragement_set);
 		
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.hide(mFragments[0]);
		fragmentTransaction.hide(mFragments[1]);
		fragmentTransaction.hide(mFragments[2]);
		fragmentTransaction.hide(mFragments[3]);
		fragmentTransaction.hide(mFragments[4]);
		fragmentTransaction.show(mFragments[0]).commit();
		setFragmentIndicator();
	}
	
	
	private class MyPageChangeListener  implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			for(int i = 0;i<imageViews.length;i++){
				imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
				
				if(arg0 != i){
					imageViews[i].setBackgroundResource(R.drawable.page_indicator);
				}
			}
		}
		
	}
	
	
	class GuidePageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pageViewsList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public int getItemPosition(Object object){
			return super.getItemPosition(object);
		}
		
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2){
			((ViewPager) arg0).removeView(pageViewsList.get(arg1));
		}
		
		@Override
		public Object instantiateItem(View arg0, int arg1){
			((ViewPager) arg0).addView(pageViewsList.get(arg1));
			return pageViewsList.get(arg1);
		}
		
		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1){}
		
		@Override
		public Parcelable saveState(){
			return null;
		}
		
		@Override
		public void startUpdate(View arg0){
			
		}
		
		@Override
		public void finishUpdate(View arg0){
			
		}
	}
	
	
	private void setFragmentIndicator(){

		
		bottomRg = (RadioGroup) findViewById(R.id.bottomRg);
//		
//		rbPlants = (RadioButton) findViewById(R.id.rbPlants);
//		rbUnits = (RadioButton) findViewById(R.id.rbUnits);
		
		bottomRg.setOnCheckedChangeListener(
				new OnCheckedChangeListener(){
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId){
						fragmentTransaction = fragmentManager.beginTransaction()
								.hide(mFragments[0]).hide(mFragments[1])
								.hide(mFragments[2]).hide(mFragments[3])
								.hide(mFragments[4]);
						
						switch(checkedId){
						case R.id.rbPlants:
							fragmentTransaction.show(mFragments[0]).commit();
							break;
						case R.id.rbUnits:
							fragmentTransaction.show(mFragments[1]).commit();
							break;
						case R.id.rbCurves:
							fragmentTransaction.show(mFragments[2]).commit();
							break;
						case R.id.rbStandard:
							fragmentTransaction.show(mFragments[3]).commit();
							break;
						case R.id.rbSet:
							fragmentTransaction.show(mFragments[4]).commit();
							break;
						default:
							break;
						}
								
					}
				});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}

	private void CreateMenu(Menu menu){
		MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
		{
			mnu1.setIcon(R.drawable.refresh);
			mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return MenuChoice(item);
	}
	
	private boolean MenuChoice(MenuItem item){
		switch(item.getItemId()){
		case 0:
			Toast.makeText(this, "You Refresh the Data",
					Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
	
	
}
