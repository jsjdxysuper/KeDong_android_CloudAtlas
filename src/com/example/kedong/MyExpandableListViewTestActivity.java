package com.example.kedong;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;


public class MyExpandableListViewTestActivity extends Activity {

	ExpandableListAdapter adapter;
	public static final String NOSELECTED = "NOSELECTED"; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_expandable_list_view_test);

		
		//创建一个BaseExpandableListAdapter对象
		adapter = new BaseExpandableListAdapter()
		{
			private String[] armTypes = new String[]
				{ "神族兵种", "虫族兵种", "人族兵种"};
			private String[][] arms = new String[][]
			{
				{ "狂战士", "龙骑士", "黑暗圣堂", "电兵" },
				{ "小狗", "刺蛇", "飞龙", "自爆飞机" },
				{ "机枪兵", "护士MM" , "幽灵" }
			};
			// 获取指定组位置、指定子列表项处的子列表项数据
			@Override
			public Object getChild(int groupPosition, int childPosition)
			{
				return arms[groupPosition][childPosition];
			}
		
			@Override
			public long getChildId(int groupPosition, int childPosition)
			{
				return childPosition;
			}
		
			@Override
			public int getChildrenCount(int groupPosition)
			{
				return arms[groupPosition].length;
			}
		
			private TextView getTextView()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				TextView textView = new TextView(MyExpandableListViewTestActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
//				textView.setPadding(40, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
		
			// 该方法决定每个子选项的外观
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent)
			{
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition)
						.toString());
				textView.setPadding(100, 0, 0, 0);
				return textView;
			}
		
			// 获取指定组位置处的组数据
			@Override
			public Object getGroup(int groupPosition)
			{
				return armTypes[groupPosition];
			}
		
			@Override
			public int getGroupCount()
			{
				return armTypes.length;
			}
		
			@Override
			public long getGroupId(int groupPosition)
			{
				return groupPosition;
			}
		
			// 该方法决定每个组选项的外观
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent)
			{
				LinearLayout ll = new LinearLayout(MyExpandableListViewTestActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(MyExpandableListViewTestActivity.this);
				if(!isExpanded)
					logo.setImageResource(R.drawable.arrow_right_icon);
				else
					logo.setImageResource(R.drawable.arrow_down_icon);
				
				LayoutParams layoutParams = new LayoutParams(50,50);
				logo.setLayoutParams(layoutParams);
				logo.setPadding(20, 0, 0, 0);
				
				ll.addView(logo);
				TextView textView = getTextView();
				textView.getHeight();
				textView.setText(getGroup(groupPosition).toString());
				textView.setTextSize(20);
//				textView.setTex
				ll.addView(textView);
				return ll;
			}
		
			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition)
			{
				return true;
			}
		
			@Override
			public boolean hasStableIds()
			{
				return true;
			}
		};
		
		ExpandableListView expandListView = (ExpandableListView) findViewById(R.id.list);
		expandListView.setAdapter(adapter);
		expandListView.setOnChildClickListener(new OnChildClickListener(){

			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1,
					int groupPosition, int childPosition, long arg4) {
				// TODO Auto-generated method stub
//				Toast.makeText(MyExpandableListViewTestActivity.this,
//						"你点击了"+adapter.getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show();
				Intent intent = getIntent();
				intent.putExtra("plant", (String)adapter.getChild(groupPosition, childPosition));
				MyExpandableListViewTestActivity.this.setResult(0, intent);
				MyExpandableListViewTestActivity.this.finish();
				
				return false;
			}
		});

		//设置header中的返回按钮的监听事件，如果按返回按钮，什么也没有添加
		ImageView imageView = (ImageView) findViewById(R.id.cancelInExpandableListViewActivity);
		imageView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				intent.putExtra("plant", NOSELECTED);
				MyExpandableListViewTestActivity.this.setResult(0, intent);
				MyExpandableListViewTestActivity.this.finish();
			}
			
		});
		
		
//		expandListView
//		expandListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//			
//			@Override
//			public void onGroupExpand(int groupPosition) {
//				// TODO Auto-generated method stub
//				View view = adapter.getGroupView(groupPosition, true, null, null);
//				expandListView.setGroupIndicator();
//			}
//		});

	}

	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK )
		{
//			// 创建退出对话框
//			AlertDialog isExit = new AlertDialog.Builder(this).create();
//			// 设置对话框标题
//			isExit.setTitle("系统提示");
//			// 设置对话框消息
//			isExit.setMessage("确定要退出吗");
//			// 添加选择按钮并注册监听
//			isExit.setButton("确定", listener);
//			isExit.setButton2("取消", listener);
//			// 显示对话框
//			isExit.show();
			
			Intent intent = getIntent();
			intent.putExtra("plant", "NOPLANTSELECT");
			MyExpandableListViewTestActivity.this.setResult(0, intent);
			MyExpandableListViewTestActivity.this.finish();
			
			return false;
		}
		
		return false;
		
	}

}
