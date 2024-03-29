package com.example.kedong;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ToggleButton;
import android.os.Build;

public class AddPlantsActivity extends Activity {

	private AddPlantsAdapter adapter;
	private GridView gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.add_plants_gridview_main, null);
		ArrayList<String> strs = new ArrayList<String>();
		
		strs.add("大连");
		strs.add("锦州");
		strs.add("鞍山");
		strs.add("铁岭");
		strs.add("盘锦");
		strs.add("沈阳");
		strs.add("");
		
		
		//为GridView的最后一个加号item添加选择电厂时间，点击后跳入ListView的Activity选择要添加的电厂
		adapter=new AddPlantsAdapter(strs, this);
		gridView=(GridView) viewGroup.findViewById(R.id.grid);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {   
		            @Override
		            public void onItemClick(AdapterView<?> arg0, View arg1,   
		                            int position, long arg3) {  
		            	if(adapter.isAddButton(position))
		            	{
		            		Toast.makeText(AddPlantsActivity.this, "添加电厂", Toast.LENGTH_SHORT).show();
		            		Intent intent = new Intent(AddPlantsActivity.this,MyExpandableListViewTestActivity.class);
		            		startActivityForResult(intent,0);
		            	}
		            	else
		            		adapter.deletItem(position);
		            }   
		    });   
		
		
		
		ToggleButton editPlantsInAddPlantsActivity = (ToggleButton)viewGroup.findViewById(R.id.editPlantsInAddPlantsActivity);
		editPlantsInAddPlantsActivity.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
					adapter.editAll();
				else
					adapter.cancelEditAll();
			}
		});
		
		
		ImageView cancelInAddPlantsActivity = (ImageView)viewGroup.findViewById(R.id.cancelInAddPlantsActivity);
		cancelInAddPlantsActivity.setClickable(true);
		cancelInAddPlantsActivity.setFocusable(true);
		cancelInAddPlantsActivity.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				intent.putExtra("PlantList", "aaa");
				AddPlantsActivity.this.setResult(1, intent);
				AddPlantsActivity.this.finish();
			}
			
		});
		setContentView(viewGroup);


	}


	/**
	 * 获得从MyExpandableListViewTestActivity活动选择要添加的电厂
	 * key为"plant",如果value为MyExpandableListViewTestActivity.NOSELECTED代表什么都没选择就退回来了
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
		if(requestCode == 0 && resultCode == 0)
		{
			Bundle data = intent.getExtras();
			String resultPlants = data.getString("plant");
			if(resultPlants.compareTo(MyExpandableListViewTestActivity.NOSELECTED) != 0 )
				adapter.addPlant(resultPlants);
		}
	}
}
