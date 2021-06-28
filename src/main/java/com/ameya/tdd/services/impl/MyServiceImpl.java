package com.ameya.tdd.services.impl;

import com.ameya.tdd.daos.MyDao;
import com.ameya.tdd.services.MyService;

public class MyServiceImpl implements MyService{

	private MyDao dao;
	public MyServiceImpl(MyDao dao) {
		this.dao=dao;
	}
	
	public int findTheGreatestFromAllData() {
	int[] data = dao.getAllData();
	int greatest = Integer.MIN_VALUE;

	for (int value : data) {
		if (value > greatest) {
			greatest = value;
		}
	}
	return greatest;
	}
}
