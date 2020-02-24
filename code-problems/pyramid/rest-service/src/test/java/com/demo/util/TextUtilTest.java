package com.demo.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TextUtilTest {
	private static final String SHOULD_NOT_BE_A_PYRAMID_WORD = "%s should not be a pyramid word.";
	private static final String NOT_A_PYRAMID_WORD = "%s is not a pyramid word.";

	
	@ParameterizedTest
	@ValueSource(ints = {1,3,6,10,15,21})
	void testIsTriangularValid(int number) {
		assertTrue(TextUtil.isTriangular(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1,0,2,4,5,7,12,25})
	void testIsTriangularInvalid(int number) {
		assertFalse(TextUtil.isTriangular(number), String.format("%d is a triangular number", number));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"banana", "nonana"})
	void testIsPyramid(String text) {
		boolean pyramid = TextUtil.isPyramid(text);
		assertTrue(pyramid, String.format(NOT_A_PYRAMID_WORD, text));
	}
	
	@Test
	void testIsPyramidSingleCharThenTrue() {
		String text = "a";
		boolean pyramid = TextUtil.isPyramid(text);
		assertTrue(pyramid, String.format(NOT_A_PYRAMID_WORD, text));
	}
	
	@Test
	void testIsPyramidWithTriangularLengthAndPyramidThenTrue() {
		String text = "bbbaddccccfffff";
		boolean pyramid = TextUtil.isPyramid(text);
		assertTrue(pyramid, String.format(NOT_A_PYRAMID_WORD, text));
	}
	
	@Test
	void testIsPyramidWithValidTextThenTrue() {
		String text = "hi there rreeet  tet ";
		boolean pyramid = TextUtil.isPyramid(text);
		assertTrue(pyramid, String.format(NOT_A_PYRAMID_WORD, text));
	}

	@Test
	void testIsPyramidWhenEmptyThenFalse() {
		String text = "";
		boolean pyramid = TextUtil.isPyramid(text);
		assertFalse(pyramid, "Empty string should not be pyramid");
	}
	
	@Test
	void testIsPyramidWhenNullThenFalse() {
		String text = null;
		boolean pyramid = TextUtil.isPyramid(text);
		assertFalse(pyramid, "Null should not be pyramid");
	}
	
	@Test
	void testIsPyramidWithNonPyramidWord() {
		String text = "bandana";
		boolean pyramid = TextUtil.isPyramid(text);
		assertFalse(pyramid, String.format(SHOULD_NOT_BE_A_PYRAMID_WORD, text));
	}
	
	@Test
	void testIsPyramidWithTriangularLengthButNotPyramid() {
		String text = "122333445566667";
		boolean pyramid = TextUtil.isPyramid(text);
		assertFalse(pyramid, String.format(SHOULD_NOT_BE_A_PYRAMID_WORD, text));
	}

}
