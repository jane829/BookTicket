package com.tarena.tabs.service;

import java.util.List;

public interface OrderService {
	
	/**
	 * 提交订单  需要传递给服务器航班id 与 所有的乘机人id即可  
	 * @param flightId
	 * @param psgIds
	 * @return
	 * @throws Exception
	 */
	String orderSubmit(String flightId, List<Integer> psgIds) throws Exception;
	
}
