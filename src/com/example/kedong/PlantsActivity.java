package com.example.kedong;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.os.Build;

public class PlantsActivity extends Activity {

	private Fragment[] mFragments;
	private RadioGroup bottomRg;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private RadioButton rbPlants, rbUnits, rbCurves, rbStandard, rbSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plants);
		
		mFragments = new Fragment[2];
		fragmentManager = getFragmentManager();
		mFragments[0] = fragmentManager
				.findFragmentById(R.id.fragement_plants);
		mFragments[1] = fragmentManager
				.findFragmentById(R.id.fragement_uints);
		
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.hide(mFragments[0]);
		fragmentTransaction.hide(mFragments[1]);
		fragmentTransaction.show(mFragments[0]).commit();
		setFragmentIndicator();
	}
	
	
	private void setFragmentIndicator(){
		bottomRg = (RadioGroup) findViewById(R.id.bottomRg);
		
		rbPlants = (RadioButton) findViewById(R.id.rbPlants);
		rbUnits = (RadioButton) findViewById(R.id.rbUnits);
		
		bottomRg.setOnCheckedChangeListener(
				new OnCheckedChangeListener(){
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId){
						fragmentTransaction = fragmentManager.beginTransaction()
								.hide(mFragments[0]).hide(mFragments[1]);
						
						switch(checkedId){
						case R.id.rbPlants:
							fragmentTransaction.show(mFragments[0]).commit();
							break;
						case R.id.rbUnits:
							fragmentTransaction.show(mFragments[1]).commit();
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
