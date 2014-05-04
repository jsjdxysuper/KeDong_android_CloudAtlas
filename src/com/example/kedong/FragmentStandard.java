package com.example.kedong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FragmentStandard extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_standard, container, false);
		
		ListView listView = (ListView) viewGroup.findViewById(R.id.list);
		ListView listView1 = (ListView) viewGroup.findViewById(R.id.list1);
		ListView listView2 = (ListView) viewGroup.findViewById(R.id.list2);
		
		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NAME", "����");
		map.put("CAPACITY", "����");
		map.put("MONTHPOWER", "�µ���");
		map.put("LOADRATE", "������");
		map.put("USEDHOURS", "����Сʱ��");
		contents.add(map);
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("NAME", "����");
			map1.put("CAPACITY", "500");
			map1.put("MONTHPOWER", "1542");
			map1.put("LOADRATE", "68");
			map1.put("USEDHOURS", "2450");
			contents.add(map1);
		}
		MySimpleAdapter adapter = new MySimpleAdapter(getActivity(),
				(List<Map<String, Object>>) contents, R.layout.standard_listitem,
				new String[] { "NAME", "CAPACITY", "MONTHPOWER","LOADRATE","USEDHOURS" },
				new int[] {
						R.id.listitem_name, R.id.listitem_capacity, R.id.listitem_monthpower,
						R.id.listitem_loadrate, R.id.listitem_usedhours });

		listView.setAdapter(adapter);
		listView1.setAdapter(adapter);
		listView2.setAdapter(adapter);
		Utility.setListViewHeightBasedOnChildren(listView);
		Utility.setListViewHeightBasedOnChildren(listView1);
		Utility.setListViewHeightBasedOnChildren(listView2);
		return viewGroup;
	}
	
	
//	private class MySimpleAdapter extends SimpleAdapter{
//
//		public MySimpleAdapter(Context context,
//				List<? extends Map<String, ?>> data, int resource,
//				String[] from, int[] to) {
//			super(context, data, resource, from, to);
//			// TODO Auto-generated constructor stub
//		}
//		
//		
//		@Override  
//	    public View getView(final int position, View convertView, ViewGroup parent) {  
//	        // TODO Auto-generated method stub  
//	        // listviewÿ�εõ�һ��item����Ҫviewȥ���ƣ�ͨ��getView�����õ�view  
//	        // positionΪitem�����  
//	        View view = null;  
//	        if (convertView != null) {  
//	            view = convertView;  
//	            // ʹ�û����view,��Լ�ڴ�  
//	            // ��listview��item����ʱ���϶�����סһ����item������ס��item��view����convertView�����š�  
//	            // ���������ص�֮ǰ����ס��itemʱ��ֱ��ʹ��convertView����������ȥnew view()  
//	  
//	        } else {  
//	            view = super.getView(position, convertView, parent);  
//	  
//	        }  
//	  
//	        //ʵ������Ч��
//	        int[] colors = { Color.WHITE, Color.rgb(219, 238, 244) };//RGB��ɫ  
//	  
//	        view.setBackgroundColor(colors[position % 2]);// ÿ��item֮����ɫ��ͬ  
//	  
//	        return super.getView(position, view, parent);  
//	    }  
//	}
	//��̬����listview���ܸ߶ȣ������Ϳ��԰Ѷ��listview����scrollview��
    public static class Utility {
        public static void setListViewHeightBasedOnChildren(ListView listView) {
            ListAdapter listAdapter = listView.getAdapter(); 
            if (listAdapter == null) {
                // pre-condition
                return;
            }

            int totalHeight = 0;
            for (int i = 0; i < listAdapter.getCount(); i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }

            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
            params.height += 60;
            listView.setLayoutParams(params);
        }
    }
}
