package chess;

import boardgame.Board;
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
	
	//m�todo respons�vel por colocar um pe�a no tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//m�todo respons�vel por iniciar a partida de xadrez chamando e chamar o m�todo que coloca as pe�as no tabuleiro passando para ele a coluna, a linha e a pe�a
	public void initialSetup() {
		//chama o m�todo plaeNewPiece para colocar pe�as, passando para ele a posi��o escolhida e a pe�a que deve ser movimentada
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}

}
