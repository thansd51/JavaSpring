package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.demo.beans.DataBean;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

	//요청할때 마다 새로운 객체를 만드는 bean1 등록
		@Bean
		@RequestScope
		public DataBean bean1() {
			return new DataBean();
		}
}
