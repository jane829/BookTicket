package com.tarena.tabs.service;

import java.util.List;

import com.tarena.tabs.entity.Branch;

public interface BranchService {
	/**
	 * ͨ���������� ���������б�
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public List<Branch> findByCity(String city)throws Exception; 
}



