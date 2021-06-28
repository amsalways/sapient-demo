package com.ameya.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.ameya.tdd.daos.MyDao;
import com.ameya.tdd.services.MyService;
import com.ameya.tdd.services.impl.MyServiceImpl;


public class MyServiceTest {
	
	 MyDao dao;
	MyService service;
	
	@Before
	public void load() {
		//MockitoAnnotations.initMocks(this);
		dao=Mockito.mock(MyDao.class);
		service=new MyServiceImpl(dao);
		System.out.println("++++ Loaded mocks and injected ++++");
	}
	@After
	public void tearDown() {
		service=null;
		System.out.println("++++ Destroyed the Objects ++++");
	}
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dao.getAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, service.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dao.getAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, service.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dao.getAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, service.findTheGreatestFromAllData());
	}
	

}
