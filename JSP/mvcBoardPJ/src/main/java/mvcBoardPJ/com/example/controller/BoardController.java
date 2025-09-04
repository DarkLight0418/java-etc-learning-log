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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


// goView() 메소드부터 밑에 있는 유틸 메소드들 사용함

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final PostService postService = PostService.getInstance();
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		logParams(request);
		
		String type = request.getParameter("type");
		if (type != null) {
			type = type.trim();
			switch(type) {
				case "login": goLogin(request, response); break;
				case "check": check(request, response); break;
				case "board": goBoard(request, response); break;
				case "list": goList(request, response); break;
				case "view": goView(request, response); break;
				case "insert": insert(request, response); break;
				default: response.sendRedirect("index.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	private void goLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String login = "/login/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(login);
		rd.forward(request, response);
	}
	
	private void check(HttpServletRequest request, HttpServletResponse response) 
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
	
	private void goBoard(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String board = "/content/view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(board);
		rd.forward(request, response);
	}
	
	private void goList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ArrayList<Post> postList = postService.getPostList();
		
		String list = "/board/list.jsp";
		
		request.setAttribute("list", postList);
		RequestDispatcher rd = request.getRequestDispatcher(list);
		rd.forward(request, response);
	}
	
	private void goView(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// String idStr = request.getParameter("post");
		Long postId = readPostId(request);
		
		if (postId == null) {
			// post 파라미터가 없거나 숫자가 아닐 때(400)
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 게시글 ID");
			return;
		}
		
		Post post = postService.loadPost(postId);
		if (post == null) {
			// 없는 글(404)
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "게시글을 찾을 수 없습니다.");
			return;
		}
		
		request.setAttribute("post", post);
		
		forward(request, response, "/content/view.jsp");
	}
	
	
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostService postService = PostService.getInstance();
		
		Post dto = new Post(-1, 0, email, title, content, null, null);
		
		boolean flag = postService.insertPost(dto);
		request.setAttribute("flag", flag);
		request.setAttribute("kind", "insert");
		
		String input = "/board/insert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(input);
		rd.forward(request, response);
	
	}
	
	
	/* 유틸 메소드 모아둔 거*/
	
	private void forward(HttpServletRequest req, HttpServletResponse resp, String view)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
	
	private String param(HttpServletRequest request, String name, String def) {
		String v = request.getParameter(name);
		return (v == null || v.isBlank()) ? def : v.trim();
	}
	
	private int parseInt(String s, int def) {
		try {return Integer.parseInt(s); } catch (Exception e) {return def;}
	}
	
	private Long tryParseLong(String s) {
		try { return Long.parseLong(s); } catch (Exception e) { return null; }
	}
	
	private Long readPostId(HttpServletRequest request) {
	    for (String key : new String[]{"post", "postId", "id"}) {
	        String v = request.getParameter(key);
	        if (v != null && !v.isBlank()) {
	            try { return Long.parseLong(v.trim()); } catch (NumberFormatException ignore) {}
	        }
	    }
	    return null;
	}

	private void logParams(HttpServletRequest req) {
	    System.out.println("[DEBUG] URI=" + req.getRequestURI()
	        + " QS=" + req.getQueryString());
	    req.getParameterMap().forEach((k, v) ->
	        System.out.println("  param " + k + " = " + java.util.Arrays.toString(v)));
	}

}
	
