package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comment;
import model.News;
import service.CommentService;
import service.NewsService;

/**
 * Servlet implementation class CreateNews
 */
@WebServlet("/Comentario.do")
public class CreateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int noticiaId = Integer.parseInt(request.getParameter("noticiaId"));
		String nome = request.getParameter("nome");		
		String texto = request.getParameter("texto");
		
		Comment comment = new Comment(0, nome, noticiaId, texto);
		
		CommentService commentService = new CommentService();
		commentService.cadastrar(comment);
		
		response.sendRedirect("Noticia.html?id="+noticiaId);
	}

}
