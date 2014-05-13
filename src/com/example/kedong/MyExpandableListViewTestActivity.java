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

		
		//����һ��BaseExpandableListAdapter����
		adapter = new BaseExpandableListAdapter()
		{
			private String[] armTypes = new String[]
				{ "�������", "�������", "�������"};
			private String[][] arms = new String[][]
			{
				{ "��սʿ", "����ʿ", "�ڰ�ʥ��", "���" },
				{ "С��", "����", "����", "�Ա��ɻ�" },
				{ "��ǹ��", "��ʿMM" , "����" }
			};
			// ��ȡָ����λ�á�ָ�����б�������б�������
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
		
			// �÷�������ÿ����ѡ������
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
		
			// ��ȡָ����λ�ô���������
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
		
			// �÷�������ÿ����ѡ������
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
//						"������"+adapter.getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show();
				Intent intent = getIntent();
				intent.putExtra("plant", (String)adapter.getChild(groupPosition, childPosition));
				MyExpandableListViewTestActivity.this.setResult(0, intent);
				MyExpandableListViewTestActivity.this.finish();
				
				return false;
			}
		});

		//����header�еķ��ذ�ť�ļ����¼�����������ذ�ť��ʲôҲû�����
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
//			// �����˳��Ի���
//			AlertDialog isExit = new AlertDialog.Builder(this).create();
//			// ���öԻ������
//			isExit.setTitle("ϵͳ��ʾ");
//			// ���öԻ�����Ϣ
//			isExit.setMessage("ȷ��Ҫ�˳���");
//			// ���ѡ��ť��ע�����
//			isExit.setButton("ȷ��", listener);
//			isExit.setButton2("ȡ��", listener);
//			// ��ʾ�Ի���
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
