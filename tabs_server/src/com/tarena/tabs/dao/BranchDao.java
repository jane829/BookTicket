package com.tarena.tabs.dao;

import java.util.List;

import com.tarena.tabs.entity.Branch;

public interface BranchDao {
	/**
	 * 通过城市名称  获取网点列表
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public List<Branch> findByCity(String city) throws Exception;
}
