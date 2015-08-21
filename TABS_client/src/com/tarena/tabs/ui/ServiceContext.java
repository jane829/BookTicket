package com.tarena.tabs.ui;

import java.util.Calendar;
import java.util.List;

import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.entity.City;
import com.tarena.tabs.entity.Flight;
import com.tarena.tabs.entity.Passanger;
import com.tarena.tabs.entity.User;
import com.tarena.tabs.service.BranchService;
import com.tarena.tabs.service.CityService;
import com.tarena.tabs.service.FlightService;
import com.tarena.tabs.service.OrderService;
import com.tarena.tabs.service.PassangerService;
import com.tarena.tabs.service.UserService;
import com.tarena.tabs.service.impl.BranchServiceImpl;
import com.tarena.tabs.service.impl.CityServiceImpl;
import com.tarena.tabs.service.impl.FlightServiceImpl;
import com.tarena.tabs.service.impl.OrderServiceImpl;
import com.tarena.tabs.service.impl.PassangerServiceImpl;
import com.tarena.tabs.service.impl.UserServiceImpl;

public class ServiceContext {

	private static ServiceContext serviceContext;
	private UserService userService;
	private CityService cityService;
	private FlightService flightService;
	private BranchService branchService;
	private PassangerService passangerService;
	private OrderService orderService;
	
	private ServiceContext() {
		this.userService = new UserServiceImpl();
		this.cityService = new CityServiceImpl();
		this.flightService = new FlightServiceImpl();
		this.branchService = new BranchServiceImpl();
		this.passangerService = new PassangerServiceImpl();
		this.orderService = new OrderServiceImpl();
	}

	public static ServiceContext getServiceContext() {
		if (serviceContext == null) {
			serviceContext = new ServiceContext();
		}
		return serviceContext;
	}

	/**
	 * @param name
	 * @param pwd
	 * @return
	 */
	public String login(String name, String pwd) {
		try {
			userService.login(name, pwd);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "ok";
	}

	/**
	 * @return
	 */
	public List<City> findAllCities() {
		List<City> cities = null;
		try {
			cities = cityService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}

	public List<Flight> findFlightByCityAndDate(String fromCity, String toCity, Calendar c) {
		List<Flight> flights = null;
		try {
			flights = flightService.findByCityAndDate(fromCity, toCity, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}

	public List<Branch> findBranchByCity(String city) {
		List<Branch> branchs = null;
		try {
			branchs = branchService.findByCity(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branchs;
	}

	public List<Passanger> getMyPassangers() {
		List<Passanger> ps = null;
		try {
			ps = passangerService.findMyPassangers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	public String updatePassangerInfo(Passanger passanger) {
		String res="";
		try {
			res=passangerService.updatePassanger(passanger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String orderSubmit(String id, List<Integer> psgIds) {
		String res="";
		try {
			res =orderService.orderSubmit(id, psgIds);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return res;
	}

	public String removeMyPassangers(List<Integer> ids) {
		String res = "";
		try {
			res = passangerService.removeAllByIds(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String regist(User user) {
		String res = "ok";
		try {
			res = userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String addPassanger(Passanger passanger) {
		String res = "";
		try{
			res = passangerService.addPassanger(passanger);
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	public String modifyPwd(String op, String np1) {
		String res = "";
		try {
			res=userService.modifyPwd(op, np1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}






