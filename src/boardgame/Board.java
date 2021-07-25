package boardgame;

public class Board {
	
	//atributos da classe
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//criando construtor personalizado com os atributos rows e columns como parâmetro
	public Board(int rows, int columns) {
		//validando se o tabuleiro quando for criado irá ter pelo menos uma linha e uma coluna, caso não tenha é lançada a exceção personalizada
		if(rows < 1 || columns < 1) {
			//caso tenha entrado no if a exceção é lançada
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
	
	//retornando uma peça em determinada posição na matriz de peças
	public Piece piece(int row, int column) {
		//chama o método que verifica se uma posição existe no tabuleiro dada uma linha e uma coluna, caso não existe entra no if
		if(!positionExists(row, column)) {
			//caso tenha entrada neste if a exceção é lançada informando que a posição não existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		return pieces[row][column];
	}
	
	//retornado a posição de uma peça na matriz de peças
	public Piece piece(Position position) {
		//chama o método que verifica se uma posição existe no tabuleiro dada uma posição, caso não existe entra no if
		if(!positionExists(position)) {
			//caso tenha entrada neste if a exceção é lançada informando que a posição não existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//método que insere uma peça, tendo como parâmetro pice e position
	public void placePiece(Piece piece, Position position) {
		//chama o método que verifica se já existe alguma peça em uma determinada posição, caso já exista entra no if e lança a exceção
		if(thereIsAPiece(position)) {
			//lança a exceção informando que já existe uma peça na posição e mostra a posição
			throw new BoardException("There is already a piece on position " + position);
		}
		//peça inserida na matriz de peças
		pieces[position.getRow()][position.getColumn()] = piece;
		//passando a posição da peça para piece.position
		piece.position = position;
	}
	
	//verificando se uma posição existe no tabuleiro com base em uma determinada linha e coluna, e retornando um booleano para caso ela exista ou não
	private boolean positionExists(int row, int column) {
		//compara a linha e a coluna com a quantidade de linhas e colunas existentes no tabuleiro
		//se uma posição existe é porque ela está dentro do tabuleiro
		return row >= 0 && row < rows && column >=0 && column < columns; 
	}
	
	//verificando se uma posição existe com base em uma determinada posição e retornando um booleano para caso ela exista ou não
	public boolean positionExists(Position position) {
		//chama o método positionExists passando a linha e a coluna de uma determinada posição
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//verificando se já existe uma peça em uma determinada posição, e retorna um booleano para caso ela exista ou não
	public boolean thereIsAPiece(Position position) {
		//chama o método que verifica se uma posição existe no tabuleiro dada uma posição, caso não existe entra no if
		if(!positionExists(position)) {
			//caso tenha entrada neste if a exceção é lançada informando que a posição não existe no tabuleiro
			throw new BoardException("Position not on the board!");
		}
		//testa se na posição em questão existe um null ou não
		//se existir um null é porque não tem peça no local
		return piece(position) != null;
	}
}
