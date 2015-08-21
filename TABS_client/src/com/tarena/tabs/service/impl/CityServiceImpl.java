package com.tarena.tabs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.tabs.entity.City;
import com.tarena.tabs.service.CityService;

public class CityServiceImpl implements CityService{
		
	public List<City> findAll() throws Exception {
		City c1 = new City(1, "北京",1, "beijing");
		City c2 = new City(2, "天津",1, "tianjin");
		City c3 = new City(3, "上海",1, "shanghai");
		List<City> cities = new ArrayList<City>();
		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		return cities;
	}
	
}
