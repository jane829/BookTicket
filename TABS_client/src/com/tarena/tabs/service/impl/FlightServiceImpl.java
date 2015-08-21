package com.tarena.tabs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.util.Log;

import com.tarena.tabs.entity.Flight;
import com.tarena.tabs.service.FlightService;

public class FlightServiceImpl implements FlightService {

	public List<Flight> findByCityAndDate(String from, String to, Calendar c) throws Exception {
		Log.i("service params:", "from:"+from+"   to:"+to+"   c"+(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
		Flight f1 = new Flight("L1234", "L1234", "2013-10-10", "2013-10-10", "10:00", "11:00", "波音-737", "666.00",
				"北京首都机场T2", "北京首都机场", "11", "北京", "上海");
		f1.setFlightNum("L1234");
		f1.setCurrentPrice(700);
		f1.setTax1Price(50);
		f1.setTax2Price(150);
		Flight f2 = new Flight("L1234", "L1234", "2013-10-10", "2013-10-10", "10:00", "11:00", "波音-737", "666.00",
				"北京首都机场T2", "北京首都机场", "11", "北京", "上海");
		f2.setFlightNum("L1234");
		f2.setCurrentPrice(700);
		f2.setTax1Price(50);
		f2.setTax2Price(150);
		List<Flight> flights = new ArrayList<Flight>(); 
		flights.add(f1);
		flights.add(f2);
		return flights;
	}

}
