package model;

public class Comment {
		private int id;
		private String nome;
		private int noticiaId;
		private String texto;
		
		public Comment() {}
		
		public Comment(int id, String nome, int noticiaId, String texto) {
			super();
			this.id = id;
			this.nome = nome;
			this.noticiaId = noticiaId;
			this.texto = texto;		
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getNoticiaId() {
			return noticiaId;
		}

		public void setNoticiaId(int noticiaId) {
			this.noticiaId = noticiaId;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}
}
