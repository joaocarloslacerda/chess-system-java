package boardgame;

public abstract class Piece {
	
	//atributos da classe
	protected Position position;
	private Board board;
	
	//criando construtor personalizado tendo como par�metro o atributo board
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
	
	//m�todo respons�vel por verificar se existe algum movimento poss�vel para uma determinada pe�a realizar
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		//percorrendo cada posi��o da matriz
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					//retornando true para caso seja poss�vel movimentar a pe�a
					return true;
				}
			}
		}
		//retornando false caso n�o seja poss�vel movimentar a pe�a
		return false;
	}
}
