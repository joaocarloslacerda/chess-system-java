package chess;

import boardgame.Board;
import boardgame.Piece;

//subclasse ChessPiece herda a classe Piece com os seus dados e funcionalidades
public class ChessPiece extends Piece{

	private Color color;
	
	//criando construtor personalizado com os atributos color e o atributo board da superclasse como parâmetro
	public ChessPiece(Board board, Color color) {
		//super repassa o atributo board para a superclasse Piece
		super(board);
		this.color = color;
	}
	
	//retornando o atributo color
	public Color color() {
		return color;
	}
	
}
