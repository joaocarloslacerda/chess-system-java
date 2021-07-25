package boardgame;

//classe BoardEception herda a classe RuntimeException, para que desta forma seja op��o o tratamento de uma determinada exce��o
public class BoardException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//cria construtor padr�o sendo que ele tem como par�metro o atributo msg do tipo String
	public BoardException(String msg) {
		//super repassa a mensagem para o construtor da super classe que no caso � a classe RuntimeException
		super(msg);
	}
}
