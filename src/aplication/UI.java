package aplication;

import chess.ChessPiece;

//classe UI(user interface ou interface do usuário
public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o número da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o método que verifica se tem ou não uma peça na posição, passando como parãmetro o dado contido no local
				printPiece(pieces[i][j]);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece) {
		//caso não tenha peça na posição entra no if e printa um -
		if(piece == null) {
			System.out.print("-");
		}
		//caso tenha uma peça entra no else e printa a peça
		else {
			System.out.print(piece);
		}
		//espaçamento entre cada peça
		System.out.print(" ");
	}

}
