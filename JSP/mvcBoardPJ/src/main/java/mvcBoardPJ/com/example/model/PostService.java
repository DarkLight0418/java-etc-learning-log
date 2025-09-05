package mvcBoardPJ.com.example.model;

import java.util.ArrayList;

import mvcBoardPJ.com.example.domain.Post;

public class PostService {
	private static final PostService instance = new PostService();
	
	private BoardDAO boardDao;
	
	public PostService() {
		this.boardDao = new BoardDAO();
	}
	
	public static PostService getInstance() {
		return instance;
	}
	
	public ArrayList<Post> getPostList() {
		return boardDao.getList();
	}
	
	public Post loadPost(long postId) {
		return boardDao.loadPost(postId);
	}
	
	public boolean insertPost(Post dto) {
		return boardDao.insert(dto);
	}
}
