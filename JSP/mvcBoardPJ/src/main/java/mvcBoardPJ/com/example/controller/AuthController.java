package mvcBoardPJ.com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcBoardPJ.com.example.model.LoginService;

import java.io.IOException;

@WebServlet("/auth.do")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	LoginService loginService = LoginService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String t = request.getParameter("t");
		
		if (t == null) {
			response.sendRedirect(request.getContextPath() + "/");
		}
	
		switch (t) {
			case "form": loginform(request, response); break;
			case "check": check(request, response); break;
			case "register": register(request, response); break;
		}
	}
	private void loginform(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
		rd.forward(request, response);
	}
	
	private void check(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if (id == null || pwd == null || id.isBlank() || pwd.isBlank()) {
			request.setAttribute("errorMsg", "아이디 비밀번호를 입력하세요");
			RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
		}
		
		LoginService service = LoginService.getInstance();   // new LoginService() 안써도 된다!
		String result = service.check(id, pwd);
		System.out.println("@로그인 컨트롤러 결과 : " + result);
		
		if ("success".equals(result)) {
			String success = "/login/successLogin.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(success);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login/failLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) session.invalidate();
		response.sendRedirect(request.getContextPath() + "/");
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		
		boolean ok = loginService.register(email, nickname, pwd == null ? "0000" : pwd);
		if (ok) {
			response.sendRedirect(request.getContextPath() + "/auth.do?t=form");
		} else {
			request.setAttribute("registerError", "duplicate");
			request.getRequestDispatcher("/login/register.jsp").forward(request, response);
			// 별도로 객체 생성 안하고 진행하는 듯
		}
	}
}