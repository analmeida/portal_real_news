package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.News;

public class NewsDAO {
	private Connection conexao;

	public NewsDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(News news) {

		String inserir = "INSERT INTO noticia (descricao, titulo, texto) VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, news.getDescricao());
			pst.setString(2, news.getTitulo());
			pst.setString(3, news.getTexto());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Nao foi possivel manipular a tabela News.");
			ex.printStackTrace();

		}
	}

	public void alterar(News news) {

		String inserir = "UPDATE noticia SET texto = ?, descricao = ?, titulo = ?  WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, news.getTexto());
			pst.setString(2, news.getDescricao());
			pst.setString(3, news.getTitulo());
			pst.setInt(4, news.getId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Nao foi possivel manipular a tabela Noticia.");
			ex.printStackTrace();

		}
	}

	public void excluir(int id) {

		String excluirComentarios = "delete from comentario where fk_noticia_id = ? ";
		String excluirNoticia = "delete from noticia where id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(excluirComentarios)) {

			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel manipular a tabela Noticias.");
			ex.printStackTrace();
		}
		
		try (PreparedStatement pst = conexao.prepareStatement(excluirNoticia)) {

			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel manipular a tabela Noticias.");
			ex.printStackTrace();
		}
	}

	public News consultar(int id) {

		String inserir = "SELECT * FROM noticia where id = ?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();

			
			News result = new News();
			if (resultado.next()) {;
				result.setId(resultado.getInt("id"));
				result.setTitulo(resultado.getString("titulo"));
				result.setDescricao(resultado.getString("descricao"));
				result.setTexto(resultado.getString("texto"));
			}
			return result;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Noticia.");
			ex.printStackTrace();

			return null;
		}
	}
	
	public ArrayList<News> listar() {

		String inserir = "SELECT * FROM noticia";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			ResultSet resultado = pst.executeQuery();

			ArrayList<News> lista = new ArrayList<>();
			while (resultado.next()) {
				News p = new News();
				p.setId(resultado.getInt("id"));
				p.setTitulo(resultado.getString("titulo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setTexto(resultado.getString("texto"));
				lista.add(p);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Noticia.");
			ex.printStackTrace();

			return null;
		}
	}

}
