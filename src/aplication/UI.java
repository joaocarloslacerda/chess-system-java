package aplication;

import chess.ChessPiece;
import chess.Color;

//classe UI(user interface ou interface do usuário
public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//atributos constantes do tipo string que contem os códigos que correspondem a algumas cores para uso nas letras
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//atributos constantes do tipo string ue contem os códigos que correspondem a algumas cores para uso no fundo das letras
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
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
    	if (piece == null) {
            System.out.print("-");
        }
    	//caso tenha uma peça entra no else, faz a verificação da cor da peça e printa ela com a respectiva cor
        else {
        	//verifica se a peça é da cor branca, caso for entra no if
            if (piece.getColor() == Color.WHITE) {
            	//printa a peça com ela na cor branca
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            //caso não entre no if anterior, entra neste
            else {
            	//printa a peça na cor preta com ela sendo represenada na cor amarela
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
    	//printa um caracter vazio para o espaçamento
        System.out.print(" ");
	}

}
