package service;

import java.util.ArrayList;

import dao.CommentDAO;
import model.Comment;

public class CommentService {
	private CommentDAO commentDAO;
	
	public CommentService() {
		commentDAO = new CommentDAO();	
	}
	
	public void cadastrar(Comment comment) {
		commentDAO.cadastrar(comment);
	}
	
	public ArrayList<Comment> listar(int noticiaId){
		return commentDAO.listar(noticiaId);
	}
}
