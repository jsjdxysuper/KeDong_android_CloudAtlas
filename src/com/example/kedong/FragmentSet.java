package com.example.kedong;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentSet extends Fragment {
	String TAG = "-----------------------------lifecycle--------------------------";
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		
		//������������¼�����
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_set, container, false);
		View feedbackLinearViewGroup = (View)viewGroup.findViewById(R.id.feedBackInFragmentSet);
		feedbackLinearViewGroup.setClickable(true);
		feedbackLinearViewGroup.setFocusable(true);
		feedbackLinearViewGroup.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				Toast.makeText(getActivity(), "You Refresh the Data",
//				Toast.LENGTH_SHORT).show();
				final String Target_Action = "com.example.kedong.FragmentSet.FeedbackActivity";
				Intent intent = new Intent();
				intent.setAction(Target_Action);

				startActivityForResult(intent,1);
			}
			
		});
		
		
		
		//�汾�������¼�����
		View versionCheckLinearViewGroup = (View)viewGroup.findViewById(R.id.versionCheckInFragmentSet);
		versionCheckLinearViewGroup.setClickable(true);
		versionCheckLinearViewGroup.setFocusable(true);
		versionCheckLinearViewGroup.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getActivity(), "��ǰ�汾Ϊ���°汾",
				Toast.LENGTH_SHORT).show();

			}
			
		});
		
		
		//���ڼ����¼�����
		View aboutLinearViewGroup = (View)viewGroup.findViewById(R.id.aboutInFragmentSet);
		aboutLinearViewGroup.setClickable(true);
		aboutLinearViewGroup.setFocusable(true);
		aboutLinearViewGroup.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String Target_Action = "com.example.kedong.FragmentSet.AboutActivity";
				Intent intent = new Intent();
				intent.setAction(Target_Action);

				startActivityForResult(intent,1);

			}
			
		});
		
		
		//���������¼�����
		View helpLinearViewGroup = (View)viewGroup.findViewById(R.id.helpInFragmentSet);
		helpLinearViewGroup.setClickable(true);
		helpLinearViewGroup.setFocusable(true);
		helpLinearViewGroup.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String Target_Action = "com.example.kedong.FragmentSet.HelpActivity";
				Intent intent = new Intent();
				intent.setAction(Target_Action);

				startActivityForResult(intent,1);

			}
			
		});
		
		Log.d(TAG, "-------onCreateView------");		
		return viewGroup;
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		// �����־
		Log.d(TAG, "-------onAttach------");
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// �����־
		Log.d(TAG, "-------onCreate------");
	}

//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle data)
//	{
//		// �����־
//		Log.d(TAG, "-------onCreateView------");		
//		TextView tv = new TextView(getActivity());
//		tv.setGravity(Gravity.CENTER_HORIZONTAL);
//		tv.setText("����Fragment");
//		tv.setTextSize(40);
//		return tv;
//	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		// �����־
		Log.d(TAG, "-------onActivityCreated------");
	}

	@Override
	public void onStart()
	{
		super.onStart();
		// �����־
		Log.d(TAG, "-------onStart------");
	}

	@Override
	public void onResume()
	{
		super.onResume();
		// �����־
		Log.d(TAG, "-------onResume------");
	}

	@Override
	public void onPause()
	{
		super.onPause();
		// �����־
		Log.d(TAG, "-------onPause------");
	}

	@Override
	public void onStop()
	{
		super.onStop();
		// �����־
		Log.d(TAG, "-------onStop------");
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
		// �����־
		Log.d(TAG, "-------onDestroyView------");
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		// �����־
		Log.d(TAG, "-------onDestroy------");
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		// �����־
		Log.d(TAG, "-------onDetach------");
	}
}
