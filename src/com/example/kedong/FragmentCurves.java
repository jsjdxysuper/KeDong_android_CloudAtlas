package com.example.kedong;

import org.achartengine.GraphicalView;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class FragmentCurves extends Fragment {
	
	private GraphicalView gv1,gv2;
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_curves, null);
	    
		if (gv1 == null) {
			LinearLayout layout = (LinearLayout) viewGroup.findViewById(R.id.chart1);
			    AverageTemperatureChart ATC = new AverageTemperatureChart("24小时电力曲线","时间点/小时","电力MKW");
			    gv1 = ATC.execute(getActivity());
			    layout.addView(gv1, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			  } 
		  if (gv2 == null) {
			  LinearLayout layout = (LinearLayout) viewGroup.findViewById(R.id.chart2);
			    AverageTemperatureChart ATC = new AverageTemperatureChart("月度电量曲线","时间点/天","电量/MKW*H");
			    gv2 = ATC.execute(getActivity());
			    layout.addView(gv2, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			  } else {
			    gv2.repaint();
			  }
		return (View)viewGroup;
	}
	
	public void onResume() {
		  super.onResume();
//		  if (gv1 == null) {
//			  LayoutInflater inflater = LayoutInflater.from(getActivity());
//				ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_curves, null);
//			    LinearLayout layout = (LinearLayout) viewGroup.findViewById(R.id.chart1);
//			    AverageTemperatureChart ATC = new AverageTemperatureChart();
//			    gv1 = ATC.execute(getActivity());
//			    layout.addView(gv1, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
//			  } else {
//			    gv1.repaint();
//			  }
//			  
//			  if (gv2 == null) {
//				  LayoutInflater inflater = LayoutInflater.from(getActivity());
//					ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_curves, null);
//				    LinearLayout layout = (LinearLayout) viewGroup.findViewById(R.id.chart2);
//				    AverageTemperatureChart ATC = new AverageTemperatureChart();
//				    gv2 = ATC.execute(getActivity());
//				    layout.addView(gv2, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
//				  } else {
//				    gv2.repaint();
//				  }
	}
}
