package com.ameya.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ameya.services.CalculatorService1;

public class CalculatorServiceTest1 {
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		CalculatorService1.add("1,2,3");
	}
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		CalculatorService1.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		CalculatorService1.add("1,X");
	}

}
