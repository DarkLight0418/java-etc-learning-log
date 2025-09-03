package mvcBoardPJ.com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.time.LocalDateTime;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import mvcBoardPJ.com.example.domain.Member;
import mvcBoardPJ.com.example.domain.Post;

public class BoardDAO {
	private DataSource ds;
	
	BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/test_schema");
		} catch (NamingException ne) {
			System.out.println("JNDI 로딩 오류 : " + ne);
		}
	}
	
	Member getLoginInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(ZipSQL.LOGIN_INFO);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//String id = rs.getString(1);
				String pwd = rs.getString(2);
				
				return new Member(id, pwd);
			} else {
				return null;
			}
		} catch (SQLException se) {
			System.out.println("로그인 정보 불러오는 SQL 오류 : " + se);
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException se) {
				System.out.println("close 오류가 발생한다고?? : " + se);
			}
		}
	}
	Post loadPost(String postId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(ZipSQL.POST_LOAD)) {
			
			pstmt.setString(1, postId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if (!rs.next()) {
					return null;
				}
				
				Post p = new Post();
				p.setPostId(rs.getLong("post_id"));
				p.setBoardId(rs.getInt("board_id"));
				p.setEmail(rs.getString("author_email"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content_html"));
				
				/*
				post.setCreateDate(rs.getDate("created_at"));
				post.setUpdateDate(rs.getDate("updated_at"));
				*/
				
				java.sql.Timestamp cts = rs.getTimestamp("created_at");
				if (cts != null) p.setCreatedDate(cts.toLocalDateTime());
				
				java.sql.Timestamp uts = rs.getTimestamp("updated_at");
				if (uts != null) p.setUpdatedDate(uts.toLocalDateTime());
				
				return p;
			}
		} catch (SQLException se) {
			System.out.println("게시글 조회 중 SQL 예외 발생 : " + se.getMessage());
			System.out.println("조회 오류 발생한 게시글 ID : " + postId);
			return null;
		}
	}
	
	ArrayList<Post> getList() {
		ArrayList<Post> list = new ArrayList<Post>();
		
		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement()) {
			
			try (ResultSet rs = stmt.executeQuery(ZipSQL.LOAD_LIST)) {
				while(rs.next()) {
					long postId = rs.getLong(1);
					int boardId = rs.getInt(2);
					String authorEmail = rs.getString(3);
					String title = rs.getString(4);
					String content = rs.getString(5);
					LocalDateTime createdDate = rs.getTimestamp(6).toLocalDateTime();
					LocalDateTime updatedDate = rs.getTimestamp(7).toLocalDateTime();
					
					list.add(new Post(postId, boardId, authorEmail, title, content, createdDate, updatedDate));
				}
			}
			
		} catch (SQLException se) {
			
		}
		
		return list;
	}
}
