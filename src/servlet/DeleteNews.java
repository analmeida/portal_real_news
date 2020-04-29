package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.News;
import service.NewsService;

/**
 * Servlet implementation class NewsPage
 */
@WebServlet("/ExcluirNoticia.do")
public class DeleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		NewsService newsService = new NewsService();
		
		newsService.excluir(id);
		
		response.sendRedirect("index.html");
	}

}
