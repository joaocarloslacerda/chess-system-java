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
		//chama o m�todo dentro do construtor pois a partida deve ser iniciada j� com as pe�as em suas posi��es iniciais
		initialSetup();
	}
	
	//m�todo que retorna uma matriz de pe�as
	public ChessPiece[][] getPieces(){
		//inicializando a matriz mat com um new ChessPiece com um determinado n�mero de linhas e colunas
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//perconrrendo cada posi��o da matriz(tabuleiro)
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				//cada posi��o da matriz recebe cada pe�a do tabuleiro (com um downcasting de Piece para ChessPiece)
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		//retornando a matriz de pe�as da partida de xadres
		return mat;
	}
	
	//m�todo que retorna os movimentos poss�veis
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		//converte a posi��o de xadrez para uma posi��o de matriz
		Position position = sourcePosition.toPosition();
		//validando a posi��o de origem
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	//m�todo respons�vel por validar a posi��o de origem, e por chamar o m�todo que realiza a movimenta��o e retorna uma pe�a capturada
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//convertendo a posi��o atual da pe�a para uma posi��o da matriz
		Position source = sourcePosition.toPosition();
		//convertendo a nova posi��o da pe�a para uma posi��o da matriz
		Position target = targetPosition.toPosition();
		//validando se realmente existe uma pe�a na posi��o atual, contida em sourcePosition
		validateSourcePosition(source);
		//validando se a posi��o de destino � um movimento poss�vel em rela��o a posi��o de origem
		validateTargetPosition(source, target);
		//atributo capturedPiece recebe o retorno do m�todo makeMove que ir� realizar a movimenta��o da pe�a
		Piece capturedPiece = makeMove(source, target);
		//retornando o atributo capturedPiece realizando um downcasting devido ele anteriormente ser do tipo Piece
		return (ChessPiece)capturedPiece;
	}
	
	//m�todo respons�vel pela movimenta��o
	private Piece makeMove(Position source, Position target) {
		//remove a pe�a a ser movimentada da sua posi��o de origem e armazena do atributo auxilixar p
		Piece p = board.removePiece(source);
		//remove a pe�a contida na posi��o de destino e armazena no atributo capturedPiece
		Piece capturedPiece = board.removePiece(target);
		//chama o m�todo placePiece contido no board passando por par�metro a pe�a a ser movimentada e a posi�ao de destino que ela deve ser colocada
		board.placePiece(p, target);
		//retorna a pe�a que foi capturada
		return capturedPiece;
	}
	
	//m�todo que valida a exist�ncia de uma pe�a na posi��o
	private void validateSourcePosition(Position position) {
		//verifica se n�o existe pe�a na posi��o, se n�o existir o if � acessado e lan�ada a exce��o
		if(!board.thereIsAPiece(position)) {
			//lan�ando a exce��o informando que n�o existe pe�a na posi��o
			throw new ChessException("There is no piece on source position");
		}
		//verifica se n�o � poss�vel movimentar a pe�a
		if(!board.piece(position).isThereAnyPossibleMove()) {
			//lan�ando exce��o informando que n�o � poss�vel movimentar a pe�a
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	//m�todo respons�vel por validar se a posi��o de destino � um movimeto poss�vel em rela��o a posi��o de origem
	private void validateTargetPosition(Position source, Position target) {
		//testa se para a pe�a a posi��o de destino n�o � um movimento poss�vel
		if(!board.piece(source).possibleMove(target)) {
			//lan�ando exce��o informando que n�o � um movimento poss�vel
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//m�todo respons�vel por colocar pe�as no tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		//� chamado o m�todo placePice, passando para ele por par�metro uma pe�a, e tamb�m um new ChessPosition passando por par�metro a coluna e a linha da pe�a
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//m�todo respons�vel por iniciar a partida de xadrez chamando o m�todo que coloca as pe�as no tabuleiro
	public void initialSetup() {
		//inicializando pe�as, cada uma com a sua devida cor e posi��o
		//o m�todo placeNewPiece � chamado recebendo como par�metro a coluna, a linha, e a pe�a com a sua respectiva cor
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
