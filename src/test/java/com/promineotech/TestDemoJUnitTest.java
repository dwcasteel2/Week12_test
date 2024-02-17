package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(! expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Both parameters must be positive!");
		}
	}
	@ParameterizedTest
	@MethodSource("com.promineotch.TestDemoJUnitTest#argumentsForAddPositive")
	
	private static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(4, 1, 5, false),
				arguments(-1, -2, -3, true),
				arguments(0, 3, 0, true),
				arguments(1, 2, 3, false)
				);
	}
	
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(50, 50)).isEqualTo(100);
		assertThat(testDemo.addPositive(14, 16)).isEqualTo(30);
	}
	
	@Test
	void assertThatPairsOfPositveNumbersAreSubtractedCorrectly() {
		assertThat(testDemo.subtractPositive(40, 50)).isEqualTo(-10);
		assertThat(testDemo.subtractPositive(5, 2)).isEqualTo(3);
		assertThat(testDemo.subtractPositive(500, 400)).isEqualTo(100);
		assertThat(testDemo.subtractPositive(5, 5)).isEqualTo(0);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	

}
