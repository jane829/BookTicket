package com.tarena.tabs.ui;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MenuActivity extends Activity {

	private GridView gv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		setViews();
	}

	private void setViews() {
		this.gv = (GridView) findViewById(R.id.menuGridView);

		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		int[] images = new int[] { R.drawable.bt_search_flight_plan, R.drawable.bt_search_flight_plan,
				R.drawable.bt_search_flight_plan, R.drawable.bt_search_flight_plan, R.drawable.bt_search_flight_plan,
				R.drawable.bt_search_flight_plan };

		final Class[] intents = new Class[] { FlightSearchActivity.class, BranchSearchActivity.class,
				ModpwdActivity.class, ListPassangerActivity.class, FlightSearchActivity.class,
				BranchSearchActivity.class };

		for (int i = 0; i < images.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemImage", images[i]);
			lstImageItem.add(map);
		}
		SimpleAdapter saImageItems = new SimpleAdapter(this, //
				lstImageItem, R.layout.activity_menu_item, new String[] { "itemImage" }, new int[] { R.id.menuItem });
		gv.setAdapter(saImageItems);
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
				showNextActivity(intents[position]);
			}
		});

	}

	public void showNextActivity(Class cl) {
		startActivity(new Intent(this, cl));
	}
}
