package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T11HttpSessionListenerTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		session.setAttribute("AttR1", "속성1");
		session.setAttribute("AttR1", "속성11");
		session.setAttribute("AttR2", "속성2");
		
		session.removeAttribute("ARRT1");
		
//		session.invalidate();
		//HTTP 세션 영역내에 HttpSessionBindingListener를 구현한
		//객체가 바인딩 되면 호출됨.
		MySessionBindingListner bindingListener = 
					new MySessionBindingListner();
		session.setAttribute("obj", bindingListener);
		session.removeAttribute("obj");
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
