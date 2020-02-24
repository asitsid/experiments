package com.demo.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextUtil {

	/**
	 * A word is a ‘pyramid’ word if you can arrange the letters in increasing frequency, starting with 1 and continuing without gaps and without duplicates.
	 * Examples:
	 * banana is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's.
	 * bandana is not a pyramid word because you have 1 'b' and 1 'd'.
	 *
	 * @param text
	 * @return true/false
	 * 
	 */
	public static boolean isPyramid(String text) {
		if (Objects.nonNull(text) && !text.isEmpty() && isTriangular(text.length())) {

//			proceed with actual logic if text length is triangular number
			char[] charArray = text.toCharArray();
			Map<Character, Integer> charCountMap = new HashMap<>();
			Character charVal;
			for (char c : charArray) {
				charVal = Character.valueOf(c);
				if (charCountMap.containsKey(charVal)) {
					Integer count = charCountMap.get(charVal) + 1;
					charCountMap.put(charVal, count);
				} else {
					charCountMap.put(charVal, Integer.valueOf(1));
				}
			}
			Collection<Integer> values = charCountMap.values();
//			values should contain each natural number from 1 to size; any missing number breaks the pyramid.
			for (int i = 1; i <= values.size(); i++) {
				if (!values.contains(Integer.valueOf(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the length falls in the category of N(N+1)/2 or N(N+1) = Twice the length;
	 * summation of first N natural numbers.
	 * 
	 * https://en.wikipedia.org/wiki/Triangular_number
	 * 
	 * @param len
	 * @return true/false
	 */
	public static boolean isTriangular(int len) {
		if(len < 1) {
			return false;
		}
//		TODO: try to get rid of the loop and see if there is a formula/better way.
		int nnpuls1 = 0;
		int twiceLength = 2*len;
		for(int n=1; nnpuls1 <= twiceLength; n++) {
			nnpuls1 = n*(n+1);
			if(nnpuls1 == twiceLength) {
				// length is triangular.
				return true;
			}
		}
		
		return false;
	}
}
