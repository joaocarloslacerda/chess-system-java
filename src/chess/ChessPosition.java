package chess;

import boardgame.Position;

public class ChessPosition {
	
	//atributos da classe
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		//verifica se na instancia��o da classe ChessPosition os par�metros passados(column e row) est�o de acordo com o tabuleiro de xadrez
		//o tabuleiro precisa ter colunas de 'a' at� 'h' e linhas de 1 at� 8, se n�o tiver pelo menos alguma destas nomenclaturas entra no if seguinte n�o aceitando a instancia��o do ChessPosition
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			//caso entre no if lan�a a exce��o informando que ocorreu um erro na instancia��o da classe ChessPosition
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		//se passar pelo if anterior passa para os atributos(column e row) da classe os dados passados ao constutor por par�metro ao construtor da classe
		this.column = column;
		this.row = row;
	}
	
	//retornando o atributo column
	public char getColumn() {
		return column;
	}
	
	//retornando o atributo row
	public int getRow() {
		return row;
	}
	
	//fazendo a convers�o de uma posi��o na matriz para a posi��o no tabuleiro de xadre, passando a convers�o para o construtor da classe Position
	//ordem � primeiro a linha e depois a coluna, como em uma matriz
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//fazendo a convers�o de uma posi��o na matriz para a posi��o no tabuleiro de xadre, passando a convers�o para o construtor da classe ChessPosition
	//ordem � exatamente como em um tabuleiro de xadrez, primeiro vem a coluna e depois a linha, ou seja, � o inverso de como � passado para o construtor da classe Position no m�todo toPosition
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	//printando uma posi��o do tabuleiro de xadrez
	@Override
	public String toString() {
		return "" + column + row;
	}
}

