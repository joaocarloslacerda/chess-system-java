package boardgame;

public class Board {
	
	//atributos da classe
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//criando construtor personalizado com os atributos rows e columns como parâmetro
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//instanciando a matriz pieces com um new Piece tendo os atributos rows e columns como linhas e colunas
		pieces = new Piece[rows][columns];
	}
	
	//retornando o atributo rows
	public int getRows() {
		return rows;
	}
	
	//setando um número de linhas para rows
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	//retornando o atributo columns
	public int getColumns() {
		return columns;
	}
	
	//setando um número de colunas para o columns
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

}
