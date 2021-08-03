package chess;

import boardgame.Board;
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
