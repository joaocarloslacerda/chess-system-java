package boardgame;

public class Piece {
	
	//atributos da classe
	protected Position position;
	private Board board;
	
	//criando construtor personalizado tendo como parâmetro o atributo board
	public Piece(Board board) {
		this.board = board;
		//inicializando o position como null(vazio)
		position = null;
	}
	
	//retornando o atributo board
	protected Board getBoard() {
		return board;
	}
	

}
