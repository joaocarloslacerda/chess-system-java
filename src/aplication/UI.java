package aplication;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

//classe UI(user interface ou interface do usu�rio
public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//atributos constantes do tipo string que contem os c�digos que correspondem a algumas cores para uso nas letras
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//atributos constantes do tipo string ue contem os c�digos que correspondem a algumas cores para uso no fundo das letras
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	//m�todo respons�vel por limpar a tela ap�s cada intere��o do usu�rio
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	//m�todo respons�vel por ler uma posi��o informada pelo usu�rio
	public static ChessPosition readChessPosition(Scanner sc) {
		//validando leitura da posi��o
		try {
			//atributo s recebe a posi��o informada
			String s = sc.nextLine();
			//atributo column recebe o caracter referente a coluna, ou seja, � pego o caracter na posi��o 0 da string
			char column = s.charAt(0);
			//atributo row recebe o caracter referente a linha, ou seja, � pego o caracter na posi��o 1 da string e ocorre a conver�o dele para inteiro
			int row = Integer.parseInt(s.substring(1));
			//retorna um new ChessPosition, passando como par�metro a coluna e a linha da posi��o
			return new ChessPosition(column, row);
		}
		//caso ocorra alguma exce��o no bloco try, ele cai neste bloco catch e informa que ocorreu um erro na leitura da posi��o, e que valores v�lidos s�o entre a1 e h8
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro reading ChessPosition. Valid values are from a1 to h8");
		}
	}
	
	//m�todo respons�vel por printar o tabuleiro atualizado, o turno e o jogador do turno
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		//chamando o m�todo que printa o tabuleiro
		printBoard(chessMatch.getPieces());
		//quebrando a linha
		System.out.println();
		//chamando o m�todo que printa as pe�as
		printCapturedPieces(captured);
		//quebrando a linha
		System.out.println();
		//printando o turno da rodada
		System.out.println("Turn: " + chessMatch.getTurn());
		//printando o jogador da rodada
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	}

	
	//m�todo respons�vel por printar o tabuleiro tendo como par�metro a matriz de pe�as
	public static void printBoard(ChessPiece[][] pieces) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o n�mero da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o m�todo que verifica e printa se tem ou n�o uma pe�a na posi��o, passando como par�metro o dado contido no local e false informando que n�o tem a necessidade de colorir a posi��o com outra cor
				printPiece(pieces[i][j], false);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	//m�todo respons�vel por printar o tabuleiro tendo como par�metro a matriz de pe�as e a matriz com os movimentos poss�veis
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		//percorre cada linha da matriz
		for(int i=0; i<pieces.length; i++) {
			//printa o n�mero da linha
			System.out.print(8 - i + " ");
			//percorre cada coluna da matriz
			for(int j=0; j<pieces.length; j++) {
				//chama o m�todo que verifica e printa se tem ou n�o uma pe�a na posi��o, passando como par�metro o dado contido no local e os movimentos poss�veis
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			//quebra de linha
			System.out.println();
		}
		//printa a letra de cada coluna da matriz
		System.out.println("  a b c d e f g h");
	}
	
	//m�todo respons�vel por printar as posi��es do tabuleiro com o dado contido em cada posi��o e com os movimentos poss�veis coloridos se for o caso
	private static void printPiece(ChessPiece piece, boolean background) {
		//verificando se tem algum movimento poss�vel para printar, se o backgrounf conter "false" n�o entra no if
		if(background) {
			//printando a posi��o do movimento poss�vel j� colorida
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		//caso n�o tenha pe�a na posi��o entra no if e printa um -
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
    	//caso tenha uma pe�a entra no else, faz a verifica��o da cor da pe�a e printa ela com a respectiva cor
        else {
        	//verifica se a pe�a � da cor branca, caso for entra no if
            if (piece.getColor() == Color.WHITE) {
            	//printa a pe�a com ela na cor branca
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            //caso n�o entre no if anterior, entra neste
            else {
            	//printa a pe�a na cor preta com ela sendo represenada na cor amarela
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
    	//printa um caracter vazio para o espa�amento
        System.out.print(" ");
	}
	
	//m�todo respons�vel por printar as pe�as capturadas
	//este m�todo recebe como par�metro uma lista de pe�as e fica com o nome de captured
	private static void printCapturedPieces(List<ChessPiece> captured) {
		//cria uma lista de pe�as com o nome de white
		//nesta linha as pe�as armazenadas s�o filtradas para que a lista recebe apenas as brancas
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		//cria uma lista de pe�as com o nome de black
		//nesta linha as pe�as armazenadas s�o filtradas para que a lista recebe apenas as PRETAS
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		//informando que s�o as pe�as capturadas
		System.out.println("Captured pieces:");
		//informando que s�o somente as pe�as brancas primeiro
		System.out.println("White:");
		//comando que obriga as pr�ximas pe�as a serem printadas a serem somente brancas
		System.out.print(ANSI_WHITE);
		//pegando somente a lista com as pe�as brancas e printando
		System.out.println(Arrays.toString(white.toArray()));
		//resetando para a cor padr�o ap�s printar as pe�as brancas
		System.out.print(ANSI_RESET);
		//informando que s�o somente as pe�as brancas primeiro
		System.out.println("Black:");
		//comando que obriga as pr�ximas pe�as a serem printadas a serem somente amarelas
		//amarelas devido o fundo do prompt ser preto
		System.out.print(ANSI_YELLOW);
		//pegando somente a lista com as pe�as brancas e printando
		System.out.println(Arrays.toString(black.toArray()));
		//resetando para a cor padr�o ap�s printar as pe�as pretas
		System.out.print(ANSI_RESET);
		
		
	}

}
