package com.tarena.tabs.dao;

import java.util.List;

import com.tarena.tabs.entity.Branch;

public interface BranchDao {
	/**
	 * ͨ����������  ��ȡ�����б�
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public List<Branch> findByCity(String city) throws Exception;
}
