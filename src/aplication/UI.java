package aplication;

import chess.ChessPiece;

//classe UI(user interface ou interface do usu�rio
public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o n�mero da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o m�todo que verifica se tem ou n�o uma pe�a na posi��o, passando como par�metro o dado contido no local
				printPiece(pieces[i][j]);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece) {
		//caso n�o tenha pe�a na posi��o entra no if e printa um -
		if(piece == null) {
			System.out.print("-");
		}
		//caso tenha uma pe�a entra no else e printa a pe�a
		else {
			System.out.print(piece);
		}
		//espa�amento entre cada pe�a
		System.out.print(" ");
	}

}
