package com.tarena.tabs.service;

import java.util.List;

import com.tarena.tabs.entity.Branch;

public interface BranchService {
	
	/**
	 *  通过城市的名称查询网点列表
	 * @param city  北京
	 * @return
	 * @throws Exception
	 */
	List<Branch> findByCity(String city) throws Exception;

}
