package mvcBoardPJ.com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcBoardPJ.com.example.domain.Post;
import mvcBoardPJ.com.example.model.LoginService;
import mvcBoardPJ.com.example.model.PostService;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type != null) {
			type = type.trim();
			switch(type) {
				case "login": goLogin(request, response); break;
				case "check": check(request, response); break;
				case "board": goBoard(request, response); break;
				case "list": goList(request, response); break;
				default: response.sendRedirect("index.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	public void goLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String login = "/login/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(login);
		rd.forward(request, response);
	}
	
	public void check(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwdHash = request.getParameter("pwd");
		
		if (id == null || pwdHash == null) {
			request.setAttribute("errorMsg", "아이디 비밀번호를 입력하세요");
			RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
		}
		
		LoginService service = LoginService.getInstance();   // new LoginService() 안써도 된다!
		String result = service.check(id, pwdHash);
		System.out.println("@로그인 컨트롤러 결과 : " + result);
		
		if (result == "success") {
			String success = "/login/successLogin.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(success);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login/failLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	public void goBoard(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String board = "/board/view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(board);
		rd.forward(request, response);
	}
	
	public void goList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PostService postService = new PostService();
		
		ArrayList<Post> postList = postService.getPostList();
		
		String list = "/board/list.jsp";
		
		request.setAttribute("list", postList);
		RequestDispatcher rd = request.getRequestDispatcher(list);
		rd.forward(request, response);
	}
}
	
