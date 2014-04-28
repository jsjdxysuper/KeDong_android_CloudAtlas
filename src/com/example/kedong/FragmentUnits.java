package com.example.kedong;


import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentUnits extends Fragment {

	TelephonyManager telephonyManager;

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		Context context = getActivity();
		telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String NativePhoneNumber=telephonyManager.getLine1Number();
		NativePhoneNumber += "\n"+telephonyManager.getSimSerialNumber();
		NativePhoneNumber += "\n"+telephonyManager.getDeviceId();
		NativePhoneNumber += "\n"+telephonyManager.getSubscriberId();
		
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_units, container, false);
		TextView textView = (TextView)viewGroup.findViewById(R.id.textViewInFragmentUnits);
		textView.setText(NativePhoneNumber);
		return viewGroup;
	}
}
