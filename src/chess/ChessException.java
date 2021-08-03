package chess;

//classe ChessException herda a classe RuntimeException para que desta forma fica opcional o tratamento ou não de uma exceção
public class ChessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//criando construtor padrão sendo que ele tem como parâmetro o atributo msg do tipo String
	public ChessException(String msg) {
		//super repassa a mensagem para a super classe que neste caso é a classe RuntimeException
		super(msg);
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> bb9d2a0163d2e99f063fb3514a05eff7aa4fab81
