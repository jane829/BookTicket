package com.tarena.tabs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.tarena.tabs.entity.Branch;
import com.tarena.tabs.service.BranchService;

public class BranchServiceImpl implements BranchService{

	public List<Branch> findByCity(String city) throws Exception {
		Log.i("service params:", "city:"+city);
		List<Branch> branchs=new ArrayList<Branch>();
		//发送post请求  获取参数 
		HttpClient client=new DefaultHttpClient();
		String uri="http://192.168.188.178:8080/tabs_server/branch/loadBranch.do";
		HttpPost post=new HttpPost(uri);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		List<NameValuePair> pairs=new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("city", city));
		HttpEntity entity=new UrlEncodedFormEntity(pairs, "utf-8");
		post.setEntity(entity);
		HttpResponse resp=client.execute(post);
		HttpEntity resEntity=resp.getEntity();
		String json=EntityUtils.toString(resEntity);
		//json=[{branchId:1, branchName:xxx},{},{},{}]
		JSONArray ary=new JSONArray(json);
		for(int i=0; i<ary.length(); i++){
			JSONObject obj=ary.getJSONObject(i);
			Branch b=new Branch();
			b.setBranchId(obj.getInt("branchId"));
			b.setBranchAddress(obj.getString("branchAddress"));
			b.setBranchFax(obj.getString("branchFax"));
			b.setBranchName(obj.getString("branchName"));
			b.setBranchState(obj.getString("branchState"));
			b.setBranchTelephone(obj.getString("branchTelephone"));
			b.setCityId(obj.getInt("cityId"));
			b.setCityName(obj.getString("cityName"));
			//存入集合
			branchs.add(b);
		}
		//服务器短获取json 封装Arraylist
		/*Branch b1 = new Branch(1, "网点1",1, "123123123", "123456", "网点地址", "0");
		Branch b2 = new Branch(1, "网点2",1, "123123123", "123456", "网点地址", "0");
		Branch b3 = new Branch(1, "网点3",1, "123123123", "123456", "网点地址", "0");
		Branch b4 = new Branch(1, "网点4",1, "123123123", "123456", "网点地址", "0");
		Branch b5 = new Branch(1, "网点5",1, "123123123", "123456", "网点地址", "0");
		Branch b6 = new Branch(1, "网点6",1, "123123123", "123456", "网点地址", "0");
		List<Branch> branchs = new ArrayList<Branch>();
		branchs.add(b1);
		branchs.add(b2);
		branchs.add(b3);
		branchs.add(b4);
		branchs.add(b5);
		branchs.add(b6);
		*/
		return branchs;
	}
	
}
