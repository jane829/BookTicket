package com.tarena.tabs.service.impl;

import java.util.List;

import com.tarena.tabs.dao.BranchDao;
import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.service.BranchService;
import com.tarena.tabs.util.DaoFactory;

public class BranchServiceImpl implements BranchService{

	public List<Branch> findByCity(String city) throws Exception {
		BranchDao branchDao=(BranchDao)DaoFactory.getInstance("branchDao");
		return branchDao.findByCity(city);
	}
}




