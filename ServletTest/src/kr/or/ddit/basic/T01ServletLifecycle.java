package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

//애플리션 오늘부터 하는 건 메인이 필요가 없다
//url 경로만 파싱해서 메핑되어있는 서블릿만 필요한것이다 
//지금까지 우리가 한 것은 능동적인 프로그램임
//컨테이너 
public class T01ServletLifecycle extends HttpServlet {
	/*
	 * 서블릭이란?
	 * 
	 * 컨테이너(서블릿 엔진)에 의해 관리되는 자바기반 웹컴포넌트로서, 동적인 웹 컨텐츠의 생성을 가능하게 해준다.
	 */
	public T01ServletLifecycle() {
		// 생성자
		System.out.println("T01ServletLifecycle 생성자 호출됨.");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 초기화 코드 작성
		System.out.println("init() 호출된.");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 실제적인 작업 수행이 시작되는 지점. (자바의 메인메서드 역할)
		System.out.println("Serverr");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 메서드 방식이 POST인 경우 호출됨
		System.out.println("doPost() 호출됨.");
	}

	@Override
	public void destroy() {
		// 서블릭 객체 소멸시(컨테이너로부터 제거 전) 호출됨
		System.out.println("destory() 호출됨");
	}

}
