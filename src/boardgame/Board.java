package boardgame;

public class Board {
	
	//atributos da classe
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//criando construtor personalizado com os atributos rows e columns como par�metro
	public Board(int rows, int columns) {
		//validando se o tabuleiro quando for criado ir� ter pelo menos uma linha e uma coluna, caso n�o tenha � lan�ada a exce��o personalizada
		if(rows < 1 || columns < 1) {
			//caso tenha entrado no if a exce��o � lan�ada
			throw new BoardException("Erros creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		//instanciando a matriz pieces com um new Piece tendo os atributos rows e columns como linhas e colunas
		pieces = new Piece[rows][columns];
	}
	
	//retornando o atributo rows
	public int getRows() {
		return rows;
	}
	
	//retornando o atributo columns
	public int getColumns() {
		return columns;
	}
	
	//retornando uma pe�a em determinada posi��o na matriz de pe�as
	public Piece piece(int row, int column) {
		//chama o m�todo que verifica se uma posi��o existe no tabuleiro dada uma linha e uma coluna, caso n�o existe entra no if
		if(!positionExists(row, column)) {
			//caso tenha entrada neste if a exce��o � lan�ada informando que a posi��o n�o existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		return pieces[row][column];
	}
	
	//retornado a posi��o de uma pe�a na matriz de pe�as
	public Piece piece(Position position) {
		//chama o m�todo que verifica se uma posi��o existe no tabuleiro dada uma posi��o, caso n�o existe entra no if
		if(!positionExists(position)) {
			//caso tenha entrada neste if a exce��o � lan�ada informando que a posi��o n�o existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//m�todo que insere uma pe�a, tendo como par�metro pice e position
	public void placePiece(Piece piece, Position position) {
		//chama o m�todo que verifica se j� existe alguma pe�a em uma determinada posi��o, caso j� exista entra no if e lan�a a exce��o
		if(thereIsAPiece(position)) {
			//lan�a a exce��o informando que j� existe uma pe�a na posi��o e mostra a posi��o
			throw new BoardException("There is already a piece on position " + position);
		}
		//pe�a inserida na matriz de pe�as
		pieces[position.getRow()][position.getColumn()] = piece;
		//passando a posi��o da pe�a para piece.position
		piece.position = position;
	}
	
	//verificando se uma posi��o existe no tabuleiro com base em uma determinada linha e coluna, e retornando um booleano para caso ela exista ou n�o
	private boolean positionExists(int row, int column) {
		//compara a linha e a coluna com a quantidade de linhas e colunas existentes no tabuleiro
		//se uma posi��o existe � porque ela est� dentro do tabuleiro
		return row >= 0 && row < rows && column >=0 && column < columns; 
	}
	
	//verificando se uma posi��o existe com base em uma determinada posi��o e retornando um booleano para caso ela exista ou n�o
	public boolean positionExists(Position position) {
		//chama o m�todo positionExists passando a linha e a coluna de uma determinada posi��o
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//verificando se j� existe uma pe�a em uma determinada posi��o, e retorna um booleano para caso ela exista ou n�o
	public boolean thereIsAPiece(Position position) {
		//chama o m�todo que verifica se uma posi��o existe no tabuleiro dada uma posi��o, caso n�o existe entra no if
		if(!positionExists(position)) {
			//caso tenha entrada neste if a exce��o � lan�ada informando que a posi��o n�o existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		//testa se na posi��o em quest�o existe um null ou n�o
		//se existir um null � porque n�o tem pe�a no local
		return piece(position) != null;
	}
}
