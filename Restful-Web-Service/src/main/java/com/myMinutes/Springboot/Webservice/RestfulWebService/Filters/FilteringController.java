package com.myMinutes.Springboot.Webservice.RestfulWebService.Filters;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping(path = "/filterTest")
	public TestBean createBean() {
		return new TestBean("take this", "take this too", "Dont take this,secret!");
	}
	
	@GetMapping(path = "/filterallTest")
	public List<TestBean> createBeans() {
		ArrayList<TestBean> beanList = new ArrayList<TestBean>();
		beanList.add(new TestBean("take this", "take this too", "Dont take this,secret!"));
		beanList.add(new TestBean("take this2", "take this too2", "Dont take this2,secret!"));
		return beanList;
	}
}
