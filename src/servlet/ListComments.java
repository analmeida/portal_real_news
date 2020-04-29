package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Comment;
import service.CommentService;
import service.NewsService;

/**
 * Servlet implementation class ListNews
 */
@WebServlet("/Comentarios")
public class ListComments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService commentService = new CommentService();
		
		int noticiaId = Integer.parseInt(request.getParameter("noticiaId"));
		
		ArrayList<Comment> listaComentarios = commentService.listar(noticiaId);
		
		String json = new Gson().toJson(listaComentarios);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
