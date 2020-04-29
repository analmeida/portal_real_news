package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;
import service.NewsService;

/**
 * Servlet implementation class CreateNews
 */
@WebServlet("/Noticia.do")
public class CreateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String descricao = request.getParameter("Descricao");
		String titulo = request.getParameter("Titulo");
		String texto = request.getParameter("Texto");
		
		News news = new News(0, descricao, titulo, texto);
		
		NewsService newsService = new NewsService();
		newsService.cadastrar(news);
		
		response.sendRedirect("index.html");
	}

}
