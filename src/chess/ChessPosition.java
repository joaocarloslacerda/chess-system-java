package chess;

import boardgame.Position;

public class ChessPosition {
	
	//atributos da classe
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		//verifica se na instanciação da classe ChessPosition os parâmetros passados(column e row) estão de acordo com o tabuleiro de xadrez
		//o tabuleiro precisa ter colunas de 'a' até 'h' e linhas de 1 até 8, se não tiver pelo menos alguma destas nomenclaturas entra no if seguinte não aceitando a instanciação do ChessPosition
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			//caso entre no if lança a exceção informando que ocorreu um erro na instanciação da classe ChessPosition
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		//se passar pelo if anterior passa para os atributos(column e row) da classe os dados passados ao constutor por parâmetro ao construtor da classe
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
	
	//fazendo a conversão de uma posição na matriz para a posição no tabuleiro de xadre, passando a conversão para o construtor da classe Position
	//ordem é primeiro a linha e depois a coluna, como em uma matriz
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//fazendo a conversão de uma posição na matriz para a posição no tabuleiro de xadre, passando a conversão para o construtor da classe ChessPosition
	//ordem é exatamente como em um tabuleiro de xadrez, primeiro vem a coluna e depois a linha, ou seja, é o inverso de como é passado para o construtor da classe Position no método toPosition
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	//printando uma posição do tabuleiro de xadrez
	@Override
	public String toString() {
		return "" + column + row;
	}
}

