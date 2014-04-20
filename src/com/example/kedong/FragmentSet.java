package com.example.kedong;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentSet extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_set, container, false);
	}
}
