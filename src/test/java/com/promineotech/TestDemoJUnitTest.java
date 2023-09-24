package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;

import com.promineotech.com.TestDemo;

class TestDemoJUnitTest {

	private TestDemo testDemo; 
	
	
	@BeforeEach
	void setUp(){
	 testDemo = new TestDemo(); 
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
		assertThat(testDemo.addPositive(10, 15)).isEqualTo(25); 
		assertThat(testDemo.addPositive(100, 15)).isEqualTo(115);
}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
           assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		
		else {	assertThatThrownBy(() ->
		  testDemo.addPositive(a, b))
            .isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of(
		   arguments(2,4,6,false), 
		   arguments(-2,-3,-5,true),
		   arguments(5,10,15,false)
		   
		);
		//@formatter:on 
	}
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreSubtractedCorrectly() {
		
		assertThat(testDemo.subtractPositive(10, 5)).isEqualTo(5);
		assertThat(testDemo.subtractPositive(10, 7)).isEqualTo(3);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = Mockito.spy(TestDemo.class);
		doReturn(5).when(mockDemo).getRandomInt(); 
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
}
