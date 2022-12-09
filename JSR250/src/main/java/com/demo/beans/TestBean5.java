package com.demo.beans;

import javax.annotation.Resource;

public class TestBean5 {

	// autowired 와 qualifier가 동시적용
	// 변수의 이름과 동일한 이름의 Bean이 주입된다.
	@Resource
	private DataBean1 data1;

	@Resource
	private DataBean2 data2;

	public DataBean1 getData1() {
		return data1;
	}

	public DataBean2 getData2() {
		return data2;
	}

}
