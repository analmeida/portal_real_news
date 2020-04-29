package service;

import java.util.ArrayList;

import dao.NewsDAO;
import model.News;

public class NewsService {
	private NewsDAO newsDAO;
	
	public NewsService() {
		newsDAO = new NewsDAO();		
	}
	
	public void cadastrar(News news) {
		if (news.getTexto().length() < 20)
			return;
		newsDAO.cadastrar(news);
	}
	
	public void alterar(News news) {
		if (news.getTexto().length() < 20)
			return;
		newsDAO.alterar(news);
	}
	
	public void excluir(int id){
		newsDAO.excluir(id);
	}
	
	public News consultar(int id){
		return newsDAO.consultar(id);
	}
	
	public ArrayList<News> listar(){
		return newsDAO.listar();
	}
}
