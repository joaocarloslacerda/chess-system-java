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
			//bloco try para que caso ocorra alguma exceção dentro dele o bloco catch correspondente é acessado
			try {
				//chamando o método para limpar a tela antes de printar o tabuleiro, isto ocorre após cada nova interação
				UI.clearScreen();
				//pritando o tabuleiro e suas peças, além das peças capturadas
				UI.printMatch(chessMatch, captured);
				//espaçamento após o print anterior
				System.out.println();
				//solicitando para o usuário informar a posição atual da peça a ser movimentada
				System.out.println("Source: ");
				//o atributo source recebe o retorno do método readChessPosition que faz a leitura da posição informada pelo usuário
				ChessPosition source = UI.readChessPosition(sc);
				//criando uma matriz booleana que recebe uma os movimentos possíveis de uma partida a partir de uma posição de origem
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				//limpando a tela
				UI.clearScreen();
				//printando o tabuleiro com as suas peças e os movimentos possíveis já coloridos de uma determinada peça 
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				//espaçamento após o print anterior
				System.out.println();
				//solicitando para o usuário informar a posição de destino da peça a ser movimentada
				System.out.println("Target: ");
				//o atributo target recebe o retorno do método readChessPosition que faz a leitura da posição informada pelo usuário
				ChessPosition target = UI.readChessPosition(sc);
				//atributo capturedPiece recebe o retorno do método performChessMove que após as suas validações e chamada do método que movimenta a peça retorna a peça retirada do tabuleiro
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				//testando se alguma peça foi capturada
				if(captured != null) {
					//adicionando a peça capturada na lista de capturadas
					captured.add(capturedPiece);
				}
			}
			//bloco catch que é acessado caso ocorra uma exceção de erro no tabuleiro
			catch(ChessException e) {
				//printando a mensagem
				System.out.println(e.getMessage());
				//nextLine para mostrar a mensagem e aguardar um enter para então retornar para a solicitação de entrada novamente
				sc.nextLine();
			}
			//bloco catch que é acessado caso ocorra uma exceção caso tenha algum erro da entrada de dados
			catch(InputMismatchException e) {
				//printando a mensagem
				System.out.println(e.getMessage());
				//nextLine para mostrar a mensagem e aguardar um enter para então retornar para a solicitação de entrada novamente
				sc.nextLine();
			}
		}
		
	}

}
