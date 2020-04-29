package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comment;
import model.News;

public class CommentDAO {
	private Connection conexao;

	public CommentDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comment comment) {

		String inserir = "INSERT INTO comentario (nome, fk_noticia_id, texto) VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, comment.getNome());
			pst.setInt(2, comment.getNoticiaId());
			pst.setString(3, comment.getTexto());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Nao foi possivel manipular " + "a tabela News.");
			ex.printStackTrace();

		}
	}

	public ArrayList<Comment> listar(int noticiaId) {
		String inserir = "SELECT * FROM comentario WHERE fk_noticia_id = ?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, noticiaId);
			ResultSet resultado = pst.executeQuery();

			ArrayList<Comment> lista = new ArrayList<>();
			while (resultado.next()) {
				Comment c = new Comment();
				
				c.setNoticiaId(noticiaId);
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				
				lista.add(c);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Comentario.");
			ex.printStackTrace();

			return null;
		}
	}
}
