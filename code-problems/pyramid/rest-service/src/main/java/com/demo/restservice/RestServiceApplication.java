package com.demo.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
	Problem statement: Accept a string as input and return a response indicating whether a word is a pyramid word. 
	A word is a ‘pyramid’ word if you can arrange the letters in increasing frequency, starting with 1 and continuing without gaps and without duplicates.
	Examples:
	banana is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's.
	bandana is not a pyramid word because you have 1 'b' and 1 'd'.
	For any requirements not specified via an example, use your best judgement to determine expected result.
	You can use any language. When completed, please upload to a public repository, such as GitHub, and provide us with the link.
 *
 */
@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
