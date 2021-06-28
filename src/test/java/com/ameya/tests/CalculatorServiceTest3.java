package com.ameya.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ameya.services.CalculatorService3;

public class CalculatorServiceTest3 {
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		CalculatorService3.add("1,2,3");
	}
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		CalculatorService3.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		CalculatorService3.add("1,X");
	}

	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, CalculatorService3.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, CalculatorService3.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, CalculatorService3.add("3,6"));
	}

}
