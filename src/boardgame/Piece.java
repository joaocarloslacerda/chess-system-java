package boardgame;

public abstract class Piece {
	
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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
