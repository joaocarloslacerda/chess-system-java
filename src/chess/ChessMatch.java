package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
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

}
