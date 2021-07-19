package boardgame;

public class Board {
	
	//atributos da classe
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//criando construtor personalizado com os atributos rows e columns como par�metro
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
	
	//setando um n�mero de linhas para rows
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	//retornando o atributo columns
	public int getColumns() {
		return columns;
	}
	
	//setando um n�mero de colunas para o columns
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
