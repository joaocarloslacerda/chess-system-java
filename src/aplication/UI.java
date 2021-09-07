package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
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
	
	//método responsável por limpar a tela após cada intereção do usuário
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	//método responsável por ler uma posição informada pelo usuário
	public static ChessPosition readChessPosition(Scanner sc) {
		//validando leitura da posição
		try {
			//atributo s recebe a posição informada
			String s = sc.nextLine();
			//atributo column recebe o caracter referente a coluna, ou seja, é pego o caracter na posição 0 da string
			char column = s.charAt(0);
			//atributo row recebe o caracter referente a linha, ou seja, é pego o caracter na posição 1 da string e ocorre a converão dele para inteiro
			int row = Integer.parseInt(s.substring(1));
			//retorna um new ChessPosition, passando como parâmetro a coluna e a linha da posição
			return new ChessPosition(column, row);
		}
		//caso ocorra alguma exceção no bloco try, ele cai neste bloco catch e informa que ocorreu um erro na leitura da posição, e que valores válidos são entre a1 e h8
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro reading ChessPosition. Valid values are from a1 to h8");
		}
	}
	
	//método responsável por printar o tabuleiro tendo como parâmetro a matriz de peças
	public static void printBoard(ChessPiece[][] pieces) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o número da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o método que verifica e printa se tem ou não uma peça na posição, passando como parãmetro o dado contido no local e false informando que não tem a necessidade de colorir a posição com outra cor
				printPiece(pieces[i][j], false);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	//método responsável por printar o tabuleiro tendo como parâmetro a matriz de peças e a matriz com os movimentos possíveis
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o número da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o método que verifica e printa se tem ou não uma peça na posição, passando como parãmetro o dado contido no local e os movimentos possíveis
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	//método responsável por printar as posições do tabuleiro com o dado contido em cada posição e com os movimentos possíveis coloridos se for o caso
	private static void printPiece(ChessPiece piece, boolean background) {
		//verificando se tem algum movimento possível para printar, se o backgrounf conter "false" não entra no if
		if(background) {
			//printando a posição do movimento possível já colorida
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		//caso não tenha peça na posição entra no if e printa um -
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
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
