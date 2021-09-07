package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

//subclasse ChessPiece herda a classe Piece com os seus dados e funcionalidades
public abstract class ChessPiece extends Piece{

	private Color color;
	
	//criando construtor personalizado com os atributos color e o atributo board da superclasse como par�metro
	public ChessPiece(Board board, Color color) {
		//super repassa o atributo board para a superclasse Piece
		super(board);
		this.color = color;
	}
	
	//retornando o atributo color
	public Color getColor() {
		return color;
	}
	
	//m�todo que ir� verificar se existe uma pe�a oponente em uma determinada posi��o
	protected boolean isThereOpponentPiece(Position position) {
		//armazenando a pe�a que seria advers�ria no atributo p
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//testa se a pe�a � realmente advers�ria verificando se a existe uma pe�a na posi��o e se a cor dela � diferente da cor da pe�a que estamos, se for retorna ela
		return p != null && p.getColor() != color;
	}
	
}
