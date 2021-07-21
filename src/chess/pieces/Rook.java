package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//cria construtor personalizado, que apenas passa para a super classe o board e o color
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//informando que o m�todo est� sendo sobreposto
	@Override
	//printando a letra que corresponde a pe�a ROOK
	public String toString() {
		return "R";
	}
	

}
