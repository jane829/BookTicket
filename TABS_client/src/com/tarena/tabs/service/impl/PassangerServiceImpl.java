package com.tarena.tabs.service.impl;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.tarena.tabs.entity.Passanger;
import com.tarena.tabs.service.PassangerService;

public class PassangerServiceImpl implements PassangerService {

	public String addPassanger(Passanger passanger) throws Exception {
		Log.i("service params:",
				"  passanger name:" + passanger.getPsgName() + "  passanger CertifNum:" + passanger.getCertifNum()
						+ "  passanger CertifType:" + passanger.getPsgCertifType() + "  passanger email:"
						+ passanger.getPsgEmail() + "   passanger phone:" + passanger.getPsgPhone());
		// 发送请求到达服务器 传递乘机人的信息
		// 获取返回的json字符串 解析结果 返回 "ok" 或者 "异常信息"
		return "ok";
	}

	public String removeAllByIds(List<Integer> ids) throws Exception {
		Log.i("service params:",ids.toString());
		// 发送请求到服务器 删除我所选择的乘机人
		// 返回json字符串 解析结果 返回 "ok" 或者 "异常信息"
		// return "删除失败";
		return "ok";
	}

	@Override
	public List<Passanger> findMyPassangers() throws Exception {
		// 从服务器端获取json字符串 封装乘机人集合
		List<Passanger> ps = new ArrayList<Passanger>();
		for (int i = 0; i < 15; i++) {
			Passanger p1 = new Passanger(i, "张三" + i, "身份证", "123123123123", "123@qq.com", "12313123");
			ps.add(p1);
		}
		return ps;
	}

	public String updatePassanger(Passanger passanger) throws Exception {
		Log.i("service params:",
				"  passanger name:" + passanger.getPsgName() + "  passanger CertifNum:" + passanger.getCertifNum()
						+ "  passanger CertifType:" + passanger.getPsgCertifType() + "  passanger email:"
						+ passanger.getPsgEmail() + "   passanger phone:" + passanger.getPsgPhone());
		// 发送请求 更新乘机人信息 返回信息
		return "系统错误 更新失败";
	}

}
