package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet(value="/member/list.do")
public class ListMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//서비스 객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();
		
		// 회원목록 조회
		List<MemberVO> memList =  memService.selectAllMember();
		
		req.setAttribute("memList", memList);
		
		//RequestDispatcher : 요청을 화면 view에게 던진다
		//Request : 요청 
		//Dispatcher : 보내다 발송하다
		//회원목록 화면 처리하기
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher(
						"/WEB-INF/views/member/list.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
		
		
		
		
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
