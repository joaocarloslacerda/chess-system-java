package boardgame;

//classe BoardEception herda a classe RuntimeException, para que desta forma seja opção o tratamento de uma determinada exceção
public class BoardException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//cria construtor padrão sendo que ele tem como parâmetro o atributo msg do tipo String
	public BoardException(String msg) {
		//super repassa a mensagem para o construtor da super classe que no caso é a classe RuntimeException
		super(msg);
	}
}
