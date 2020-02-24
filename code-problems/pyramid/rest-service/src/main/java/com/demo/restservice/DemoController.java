package com.demo.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.util.TextUtil;

@RestController
public class DemoController {

	@GetMapping("/text/isPyramid")
	public boolean getText(@RequestParam(value = "text") String text) {
		return TextUtil.isPyramid(text);
	}
}
