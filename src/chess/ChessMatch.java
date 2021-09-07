package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		//chama o método dentro do construtor pois a partida deve ser iniciada já com as peças em suas posições iniciais
		initialSetup();
	}
	
	//método que retorna uma matriz de peças
	public ChessPiece[][] getPieces(){
		//inicializando a matriz mat com um new ChessPiece com um determinado número de linhas e colunas
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//perconrrendo cada posição da matriz(tabuleiro)
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				//cada posição da matriz recebe cada peça do tabuleiro (com um downcasting de Piece para ChessPiece)
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		//retornando a matriz de peças da partida de xadres
		return mat;
	}
	
	//método que retorna os movimentos possíveis
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		//converte a posição de xadrez para uma posição de matriz
		Position position = sourcePosition.toPosition();
		//validando a posição de origem
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	//método responsável por validar a posição de origem, e por chamar o método que realiza a movimentação e retorna uma peça capturada
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//convertendo a posição atual da peça para uma posição da matriz
		Position source = sourcePosition.toPosition();
		//convertendo a nova posição da peça para uma posição da matriz
		Position target = targetPosition.toPosition();
		//validando se realmente existe uma peça na posição atual, contida em sourcePosition
		validateSourcePosition(source);
		//validando se a posição de destino é um movimento possível em relação a posição de origem
		validateTargetPosition(source, target);
		//atributo capturedPiece recebe o retorno do método makeMove que irá realizar a movimentação da peça
		Piece capturedPiece = makeMove(source, target);
		//retornando o atributo capturedPiece realizando um downcasting devido ele anteriormente ser do tipo Piece
		return (ChessPiece)capturedPiece;
	}
	
	//método responsável pela movimentação
	private Piece makeMove(Position source, Position target) {
		//remove a peça a ser movimentada da sua posição de origem e armazena do atributo auxilixar p
		Piece p = board.removePiece(source);
		//remove a peça contida na posição de destino e armazena no atributo capturedPiece
		Piece capturedPiece = board.removePiece(target);
		//chama o método placePiece contido no board passando por parâmetro a peça a ser movimentada e a posiçao de destino que ela deve ser colocada
		board.placePiece(p, target);
		//retorna a peça que foi capturada
		return capturedPiece;
	}
	
	//método que valida a existência de uma peça na posição
	private void validateSourcePosition(Position position) {
		//verifica se não existe peça na posição, se não existir o if é acessado e lançada a exceção
		if(!board.thereIsAPiece(position)) {
			//lançando a exceção informando que não existe peça na posição
			throw new ChessException("There is no piece on source position");
		}
		//verifica se não é possível movimentar a peça
		if(!board.piece(position).isThereAnyPossibleMove()) {
			//lançando exceção informando que não é possível movimentar a peça
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	//método responsável por validar se a posição de destino é um movimeto possível em relação a posição de origem
	private void validateTargetPosition(Position source, Position target) {
		//testa se para a peça a posição de destino não é um movimento possível
		if(!board.piece(source).possibleMove(target)) {
			//lançando exceção informando que não é um movimento possível
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//método responsável por colocar peças no tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		//é chamado o método placePice, passando para ele por parâmetro uma peça, e também um new ChessPosition passando por parâmetro a coluna e a linha da peça
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//método responsável por iniciar a partida de xadrez chamando o método que coloca as peças no tabuleiro
	public void initialSetup() {
		//inicializando peças, cada uma com a sua devida cor e posição
		//o método placeNewPiece é chamado recebendo como parâmetro a coluna, a linha, e a peça com a sua respectiva cor
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
