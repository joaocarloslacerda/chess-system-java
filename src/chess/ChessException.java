package chess;

import boardgame.BoardException;

//classe ChessException herda a classe BoardException para que desta forma fica opcional o tratamento ou n?o de uma exce??o
public class ChessException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	//criando construtor padr?o sendo que ele tem como par?metro o atributo msg do tipo String
	public ChessException(String msg) {
		//super repassa a mensagem para a super classe que neste caso ? a classe RuntimeException
		super(msg);
	}
}
