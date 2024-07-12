package com.hello.hellospring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hello.hellospring.common.interceptor.TokenCheckInterceptor;

// 스프링의 웹 설정을 담당하는 클래스다 라 고 지정해주는 어노테이션이 있다.
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	// 인터셉터를 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new TokenCheckInterceptor())
		.addPathPatterns("/**") // 모든 url에 인터셉터를 걸겠다.
		.excludePathPatterns("/getLoginToken") // 토큰을 발행해주는 url은 예외처리 (인터셉터를 타지 않는다)
		.excludePathPatterns("/login/**") // 로그인 하기 전의 url 예외
		.excludePathPatterns("/board/*Form*")
		.excludePathPatterns("/board/boardList.html");
		
	}	
	
}
