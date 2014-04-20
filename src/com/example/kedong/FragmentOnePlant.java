package com.example.kedong;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOnePlant extends Fragment {
    private static final String TAG = "TestFragment";
    private String hello;// = "hello android";
    private String defaultHello = "default value";
	
	
    static FragmentOnePlant newInstance(String s) {
    	FragmentOnePlant newFragment = new FragmentOnePlant();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        newFragment.setArguments(bundle);
        return newFragment;

    }
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		
        View view = inflater.inflate(R.layout.fragment_oneplant, container, false);
//        TextView viewhello = (TextView) view.findViewById(R.id.myTextView);
//        viewhello.setText(hello);
		return view;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        hello = args != null ? args.getString("hello") : defaultHello;
    }
}
