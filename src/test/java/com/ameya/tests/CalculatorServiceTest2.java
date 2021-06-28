package com.ameya.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ameya.services.CalculatorService2;

public class CalculatorServiceTest2 {

	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		CalculatorService2.add("1,2,3");
	}
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		CalculatorService2.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		CalculatorService2.add("1,X");
	}
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, CalculatorService2.add(""));
	}
}
