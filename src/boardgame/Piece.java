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
	
	//instanciando classe abstrata que retorna uma matriz booleana
	public abstract boolean[][] possibleMoves();
	
	//
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//método responsável por verificar se existe algum movimento possível para uma determinada peça realizar
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		//percorrendo cada posição da matriz
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					//retornando true para caso seja possível movimentar a peça
					return true;
				}
			}
		}
		//retornando false caso não seja possível movimentar a peça
		return false;
	}
}
