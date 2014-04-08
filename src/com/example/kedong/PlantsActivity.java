package com.example.kedong;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class PlantsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plants);
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
