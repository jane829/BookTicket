package com.tarena.tabs.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tarena.tabs.entity.City;
import com.tarena.tabs.entity.Flight;

public class FlightSearchActivity extends Activity {
	private List<City> cities;
	private int d;
	private int m;
	private int y;
	private ListView lv;
	private Button btSearch;
	private TextView tvD;
	private TextView tvM;
	private TextView tvY;
	private Spinner spTo;
	private Spinner spFrom;
	private LinearLayout ll;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();
	private List<Flight> flights;

	private static final int HANDLER_FLIGHT_SEARCH_RESULT = 0;
	private static final int LOAD_CITY_OK=1;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HANDLER_FLIGHT_SEARCH_RESULT:
				ArrayAdapter<Flight> adapter = new ArrayAdapter<Flight>(FlightSearchActivity.this, android.R.layout.simple_list_item_1, flights);
				lv.setAdapter(adapter);
				break;
			case LOAD_CITY_OK:
				List<String> list = new ArrayList<String>();
				for (City c : cities) {
					list.add(c.getCityName());
				}
				ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(FlightSearchActivity.this, android.R.layout.simple_spinner_item, list);
				cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spFrom.setAdapter(cityAdapter);
				spTo.setAdapter(cityAdapter);
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flight_search);

		setData();
		setViews();
		setListeners();

	}

	private void setData() {
		try {
			new Thread(){
				public void run() {
					cities = serviceContext.findAllCities();
					Message msg=new Message();
					msg.what=LOAD_CITY_OK;
					handler.sendMessage(msg);
				}
			}.start();
		} catch (Exception e) {
			Toast.makeText(this, "....", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		y = c.get(Calendar.YEAR);
		m = c.get(Calendar.MONTH);
		d = c.get(Calendar.DAY_OF_MONTH);
	}

	private void setViews() {
		spFrom = (Spinner) findViewById(R.id.spinner1);
		spTo = (Spinner) findViewById(R.id.spinner2);
		tvD = (TextView) findViewById(R.id.textView4);
		tvM = (TextView) findViewById(R.id.textView6);
		tvY = (TextView) findViewById(R.id.textView8);
		btSearch = (Button) findViewById(R.id.button1);
		lv = (ListView) findViewById(R.id.listViewPassanger);
		ll = (LinearLayout) findViewById(R.id.linearLayout2);

		// ////////////////////////
		
		// ////////////////////////
		tvY.setText(String.valueOf(y));
		tvM.setText(String.valueOf(m + 1));
		tvD.setText(String.valueOf(d));
		// ////////////////////////
	}

	private void setListeners() {
		ll.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selectDate();
			}
		});

		btSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				search();
			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Flight flight = flights.get(position);
				Intent intent = new Intent(FlightSearchActivity.this, OrderInputActivity.class);
				intent.putExtra("flight", flight);
				startActivity(intent);
			}
		});
	}

	protected void selectDate() {
		DatePickerDialog dialog = new DatePickerDialog(this, new OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				y = year;
				m = monthOfYear;
				d = dayOfMonth;
				tvY.setText(String.valueOf(y));
				tvM.setText(String.valueOf(m + 1));
				tvD.setText(String.valueOf(d));
			}
		}, y, m, d);

		dialog.show();
	}

	protected void search() {
		try {

			new Thread() {
				public void run() {
					String fromCity = spFrom.getSelectedItem().toString();
					String toCity = spTo.getSelectedItem().toString();
					Calendar c = Calendar.getInstance();
					c.set(y, m, d);
					flights = serviceContext.findFlightByCityAndDate(fromCity, toCity, c);
					Message msg = new Message();
					msg.what = HANDLER_FLIGHT_SEARCH_RESULT;
					handler.sendMessage(msg);
				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
