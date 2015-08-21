package com.tarena.tabs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.tabs.dao.BranchDao;
import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.util.DBUtil;

public class BranchDaoImpl implements BranchDao{

	public List<Branch> findByCity(String city) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql="select "
				+ " b.branch_id bid,"
				+ " b.branch_name bname, "
				+ " b.city_id  cid, "
				+ " b.branch_telephone bphone, "
				+ " b.branch_fax bfax, "
				+ " b.branch_address badd, "
				+ " b.branch_state bstate, "
				+ " c.city_name cname  "
				+ " from branch b join city c on b.city_id=c.city_id "
				+ " where c.city_name like ?";
		PreparedStatement stmt =
				 conn.prepareStatement(sql);
		stmt.setString(1, "%"+city+"%");
		ResultSet res=stmt.executeQuery();
		List<Branch> bs =new ArrayList<Branch>();
		while(res.next()){
			Branch b = new Branch();
			b.setBranchId(res.getInt("bid"));
			b.setBranchAddress(res.getString("badd"));
			b.setBranchFax(res.getString("bfax"));
			b.setBranchName(res.getString("bname"));
			b.setBranchState(res.getString("bstate"));
			b.setBranchTelephone(res.getString("bphone"));
			b.setCityId(res.getInt("cid"));
			b.setCityName(res.getString("cname"));
			bs.add(b);
		}
		DBUtil.close();
		return bs;
	}
}





