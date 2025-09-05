package mvcBoardPJ.com.example.domain;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
	private long postId;
	private int boardId;
	private String email;
	private String title;
	private String content;
	private Date createdDate;
	private Date updatedDate;
	
	public Post() {}
	
	public Post(long postId, int boardId, String email, String title, String content, Date createdDate,
			Date updatedDate) {
		super();
		this.postId = postId;
		this.boardId = boardId;
		this.email = email;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	private static final DateTimeFormatter DT_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	
	/*
	public String getCreatedDateStr() {
		return createdDate != null ? createdDate.format(DT_FMT) : "";
	}
	
	public String getUpdatedDateStr() {
		return updatedDate != null ? updatedDate.format(DT_FMT) : "";
	}
	*/
	
	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
