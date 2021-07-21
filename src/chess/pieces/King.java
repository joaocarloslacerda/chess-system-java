package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	//cria construtor personalizado, que apenas passa para a super classe o board e o color
	public King(Board board, Color color) {
		super(board, color);
	}
	
	//informando que o m�todo est� sendo sobreposto
	@Override
	//printando a letra que corresponde a pe�a KING
	public String toString() {
		return "K";
	}

}
