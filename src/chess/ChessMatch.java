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
	
	//método responsável por colocar um peça no tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//método responsável por iniciar a partida de xadrez chamando e chamar o método que coloca as peças no tabuleiro passando para ele a coluna, a linha e a peça
	public void initialSetup() {
		//chama o método plaeNewPiece para colocar peças, passando para ele a posição escolhida e a peça que deve ser movimentada
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}

}
