package com.hello.hellospring.common.interceptor;

import java.io.PrintWriter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hello.hellospring.common.Constants;
import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.common.utils.JwtTokenHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 토큰 체크 인터셉터
 */
public class TokenCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TokenInterceptor preHandle() ===> " + request.getRequestURI());
		
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 Token 검증에 실패 하였습니다.";
		
		// 헤더로부터 넘어온 토큰을 검증한다.
		String authToken = request.getHeader("Authorization");
		System.out.println("authToken" + authToken);
		
		// 토큰이 존재한다면 토큰 값이 유효한지를 체크한다.
		if(authToken != null) {
			authToken = authToken.replace("Bearer ", "");
			
			try {
				Claims claims = JwtTokenHelper.parseClaims(authToken).getBody();
				String id = claims.getId();
				String issuer = claims.getIssuer();
				String subject = claims.getSubject();
				System.out.println("id: " + id + " issuer: " + issuer + " subject: " + subject);
				result = Constants.RESULT_VAL_OK;
				resultMsg = "회원정보 Token 검증에 성공 하였습니다.";
				
				// 위의 토큰정보를 세션객체에 담아서 Controller 에 전달하여 컨트롤러 쪽에서 사용하도록 제공한다.
				HttpSession session = request.getSession();
				MemberBean memberBean = new MemberBean();
				memberBean.setId(id);
				memberBean.setMemberNo(issuer);
				memberBean.setHp(subject);
				session.setAttribute(Constants.KEY_SESSION_MEMBER_BEAN, memberBean);
				
				return true; // 인터셉터 영역을 통과
			} catch (ExpiredJwtException expException) {
				expException.printStackTrace();
				resultMsg = "Token 의 유효기간이 만료 되었습니다. 다시 발급 받으세요."; 
			} catch (Exception e) {
				e.printStackTrace();
				resultMsg = e.getMessage();
			}
		}
		
		// 실패한 이유에 대해서 response를 준다.
		StringBuilder jsonMsg = new StringBuilder();
		jsonMsg.append("{");
		jsonMsg.append("\"result\"");
		jsonMsg.append(":");
		jsonMsg.append("\"");
		jsonMsg.append(Constants.RESULT_VAL_FAIL);
		jsonMsg.append("\"");
		jsonMsg.append(", \"resultMsg\"");
		jsonMsg.append(":");
		jsonMsg.append("\"");
		jsonMsg.append(resultMsg);
		jsonMsg.append("\"");
		jsonMsg.append("}");
		
		PrintWriter writer = response.getWriter();
		writer.write(jsonMsg.toString());
		writer.flush();
		writer.close();
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TokenInterceptor postHandle() <=== ");
		
		// 세션 초기화
		request.getSession().setAttribute(Constants.KEY_SESSION_MEMBER_BEAN, null);
	}
	

}	
