package com.tarena.tabs.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.entity.City;

public class BranchSearchActivity extends Activity {
	private ListView lv;
	private Button btSearch;
	private Spinner spCity;
	private List<City> cities;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HANDLER_SEARCH_RESULT:
				List<Branch> branchs = (List<Branch>)msg.obj;
				ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(BranchSearchActivity.this, android.R.layout.simple_list_item_1, branchs);
				lv.setAdapter(adapter);
				break;
			}
		}
	};
	
	private static final int HANDLER_SEARCH_RESULT = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_branch_search);

		setData();
		setViews();
		setListeners();
	}

	private void setData() {
		try {
			List<City> cities = serviceContext.findAllCities();
			this.cities = cities;
		} catch (Exception e) {
			Toast.makeText(this, "....", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

	private void setViews() {
		spCity = (Spinner) findViewById(R.id.spinner1);
		btSearch = (Button) findViewById(R.id.button1);
		lv = (ListView) findViewById(R.id.listViewPassanger);

		List<String> list = new ArrayList<String>();
		for (City c : cities) {
			list.add(c.getCityName());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spCity.setAdapter(adapter);

	}

	private void setListeners() {
		btSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				search();
			}
		});
	}

	private void search() {
		try {

			new Thread() {
				public void run() {
					String city = (String) spCity.getSelectedItem();
					List<Branch> list = serviceContext.findBranchByCity(city);
					Message msg = new Message();
					msg.what = HANDLER_SEARCH_RESULT;
					msg.obj = list;
					handler.sendMessage(msg);
				}
			}.start();

		} catch (Exception e) {
			Toast.makeText(this, "....", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}
}
