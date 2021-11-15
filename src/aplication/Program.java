package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(true) {
			//bloco try para que caso ocorra alguma exce��o dentro dele o bloco catch correspondente � acessado
			try {
				//chamando o m�todo para limpar a tela antes de printar o tabuleiro, isto ocorre ap�s cada nova intera��o
				UI.clearScreen();
				//pritando o tabuleiro e suas pe�as, al�m das pe�as capturadas
				UI.printMatch(chessMatch, captured);
				//espa�amento ap�s o print anterior
				System.out.println();
				//solicitando para o usu�rio informar a posi��o atual da pe�a a ser movimentada
				System.out.println("Source: ");
				//o atributo source recebe o retorno do m�todo readChessPosition que faz a leitura da posi��o informada pelo usu�rio
				ChessPosition source = UI.readChessPosition(sc);
				//criando uma matriz booleana que recebe uma os movimentos poss�veis de uma partida a partir de uma posi��o de origem
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				//limpando a tela
				UI.clearScreen();
				//printando o tabuleiro com as suas pe�as e os movimentos poss�veis j� coloridos de uma determinada pe�a 
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				//espa�amento ap�s o print anterior
				System.out.println();
				//solicitando para o usu�rio informar a posi��o de destino da pe�a a ser movimentada
				System.out.println("Target: ");
				//o atributo target recebe o retorno do m�todo readChessPosition que faz a leitura da posi��o informada pelo usu�rio
				ChessPosition target = UI.readChessPosition(sc);
				//atributo capturedPiece recebe o retorno do m�todo performChessMove que ap�s as suas valida��es e chamada do m�todo que movimenta a pe�a retorna a pe�a retirada do tabuleiro
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				//testando se alguma pe�a foi capturada
				if(captured != null) {
					//adicionando a pe�a capturada na lista de capturadas
					captured.add(capturedPiece);
				}
			}
			//bloco catch que � acessado caso ocorra uma exce��o de erro no tabuleiro
			catch(ChessException e) {
				//printando a mensagem
				System.out.println(e.getMessage());
				//nextLine para mostrar a mensagem e aguardar um enter para ent�o retornar para a solicita��o de entrada novamente
				sc.nextLine();
			}
			//bloco catch que � acessado caso ocorra uma exce��o caso tenha algum erro da entrada de dados
			catch(InputMismatchException e) {
				//printando a mensagem
				System.out.println(e.getMessage());
				//nextLine para mostrar a mensagem e aguardar um enter para ent�o retornar para a solicita��o de entrada novamente
				sc.nextLine();
			}
		}
		
	}

}
