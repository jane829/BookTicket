package com.tarena.tabs.service;

import java.util.List;

import com.tarena.tabs.entity.Branch;

public interface BranchService {
	/**
	 * 通过城市名称 返回网点列表
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public List<Branch> findByCity(String city)throws Exception; 
}



