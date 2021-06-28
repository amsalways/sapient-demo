package com.ameya.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CalculatorServiceTest1.class,
	CalculatorServiceTest2.class,
	CalculatorServiceTest3.class
})
public class CalculatorServiceTestSuite {

}
