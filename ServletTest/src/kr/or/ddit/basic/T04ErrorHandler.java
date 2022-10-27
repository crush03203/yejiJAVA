package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T04ErrorHandler extends HttpServlet{
	//비연결성 stateless //상태가 유지되지 않는다
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Throwable throwable = 
				(Throwable) req.getAttribute("javax.servlet.error.exception");
		
		Integer satausCode = 
				(Integer) req.getAttribute("java.servlet.error.status_code");
		
		String msg = 
				(String)req.getAttribute("javax.servlet.error.message");

		
		String servletName = 
				(String)req.getAttribute("javax.serlet.error.servlet_name");
		
		if(servletName == null) {
			servletName = "알수없는 서블릿 이름";
			
		}
		String reqURI = (String) req.
				getAttribute("javax.servlet.error.request_uri");
		
		if(reqURI == null) {
			reqURI ="알수없는 URI";
		}
		//응답시작
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		String title = "에러/예외정보";
		
		out.print("<html><head><title>" + title 
				+ "</title></head>");
		out.print("<body>");
		
		if(throwable == null && satausCode == null ) {
			out.print("<h2>에러/예외정보 없음</h2>");
			
		} else {
			out.print("<h2>에러/예외 정보</h2>");
			out.print("상태코드 : "  + satausCode + "<br>");
			out.print("에러/예외메시지 : "  + msg + "<br>");
			out.print("서블릿 이름 : "  + servletName + "<br>");
			out.print("요청 URI : "  + reqURI + "<br>");
			if(satausCode != null) {
				out.print("예외타입: " 
							+ throwable.getClass().getName() + "<br>");
				out.print("예외/에러메시지: " 
						+ throwable.getClass() + "<br>");
			}
		}
		out.print("</body></html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	

}
