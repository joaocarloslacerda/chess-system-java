package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

//subclasse ChessPiece herda a classe Piece com os seus dados e funcionalidades
public abstract class ChessPiece extends Piece{

	private Color color;
	
	//criando construtor personalizado com os atributos color e o atributo board da superclasse como parâmetro
	public ChessPiece(Board board, Color color) {
		//super repassa o atributo board para a superclasse Piece
		super(board);
		this.color = color;
	}
	
	//retornando o atributo color
	public Color getColor() {
		return color;
	}
	
	//método que irá verificar se existe uma peça oponente em uma determinada posição
	protected boolean isThereOpponentPiece(Position position) {
		//armazenando a peça que seria adversária no atributo p
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//testa se a peça é realmente adversária verificando se a existe uma peça na posição e se a cor dela é diferente da cor da peça que estamos, se for retorna ela
		return p != null && p.getColor() != color;
	}
	
}
