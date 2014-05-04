package com.example.kedong;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentUnits extends Fragment {

	TelephonyManager telephonyManager;

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		
		
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_units, container, false);
		ListView listView = (ListView) viewGroup.findViewById(R.id.unitListInFragmentUnits);
		
		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("TIMEPOINT", "Ê±¼äµã");
		map.put("UNIT1", "#1");
		map.put("UNIT2", "#2");
		map.put("UNIT3", "#3");
		map.put("UNIT4", "#4");
		contents.add(map);
		
		
		for (int i = 0; i < 24; i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("TIMEPOINT", ""+(i+1));
			map1.put("UNIT1", ""+(400+(int)(Math.random()*100)));
			map1.put("UNIT2", ""+(400+(int)(Math.random()*100)));
			map1.put("UNIT3", ""+(400+(int)(Math.random()*100)));
			map1.put("UNIT4", ""+(400+(int)(Math.random()*100)));
			contents.add(map1);
		}
		
		MySimpleAdapter adapter = new MySimpleAdapter(getActivity(),
				(List<Map<String, Object>>) contents, R.layout.units_listitem,
				new String[] { "TIMEPOINT", "UNIT1", "UNIT2","UNIT3","UNIT4" },
				new int[] {
						R.id.listitem_timepoint, R.id.listitem_unit1, R.id.listitem_unit2,
						R.id.listitem_unit3, R.id.listitem_unit4 });
		listView.setAdapter(adapter);
//		Utility.setListViewHeightBasedOnChildren(listView);
		
		return viewGroup;
	}
}
