package com.tarena.tabs.service.impl;

import java.util.List;

import android.util.Log;

import com.tarena.tabs.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	public String orderSubmit(String flightId, List<Integer> psgIds) throws Exception {
		Log.i("service params:", "flightId:"+flightId+"  psgIds:"+psgIds.toString());
		//向服务器提交flightId与psgIds   服务器端解析过后分别保存在ticket_order表 与 ticket表中
		//解析服务器发送回来的json  {"result":"ok", "msg":"系统异常"}   
		//return "ok";
		return "系统异常";
	}
	
}
