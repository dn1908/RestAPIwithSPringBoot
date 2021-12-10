package com.myMinutes.Springboot.Webservice.RestfulWebService.Filters;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TestBean {
	private String detail1;
	private String detail2;
	
	@JsonIgnore
	private String detail3;
	
	public TestBean(String string, String string2, String string3) {
		detail1 = string;
		detail2 = string2;
		detail3 = string3;
	}
	public String getDetail1() {
		return detail1;
	}
	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}
	public String getDetail2() {
		return detail2;
	}
	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}
	public String getDetail3() {
		return detail3;
	}
	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}
	
}
