package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	//cria construtor personalizado, que apenas passa para a super classe o board e o color
	public King(Board board, Color color) {
		super(board, color);
	}
	
	//informando que o método está sendo sobreposto
	@Override
	//printando a letra que corresponde a peça KING
	public String toString() {
		return "K";
	}
	
	//método que verifica se a peça pode ser movimentada
	private boolean canMove(Position position) {
		//pegando a peça que está na posição passada por parâmetro
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//retorna p se a posição estiver vazia ou se a cor da peça não for igual a peça a ser movimentada, ou seja se for uma peça adversária
		return p == null || p.getColor() != getColor();
	}

	//metodo que retorna os possíveis movimentos de uma peça para o método possbleMovie
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//criando uma variável auxiliar e que começa
		Position p = new Position(0,0);
		
		//above
		//atualizando os valores da posição para a linha anterior da peça
		p.setValues(position.getRow() - 1, position.getColumn());
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below
		//atualizando os valores da posição para a próxima linha da peça
		p.setValues(position.getRow() + 1, position.getColumn());
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		//atualizando os valores da posição para a coluna anterior da peça
		p.setValues(position.getRow(), position.getColumn() - 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		//atualizando os valores da posição para a próxima coluna da peça
		p.setValues(position.getRow(), position.getColumn() + 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//nw
		//atualizando os valores da posição para a linha e a coluna anterior da peça
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//ne
		//atualizando os valores da posição para a linha anterior e a prócima coluna da peça
		p.setValues(position.getRow() - 1 , position.getColumn() + 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//sw
		//atualizando os valores da posição para a próxima linha e a coluna anterior da peça
		p.setValues(position.getRow() + 1 , position.getColumn() - 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//se
		//atualizando os valores da posição para a próxima linha e a próxima coluna da peça
		p.setValues(position.getRow() + 1 , position.getColumn() + 1);
		//verifica se a posição existe no tabuleiro e se é permitido movimentar a peça para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posição existe e é permitido movimentar a peça para ela, a mesma é marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		
		return mat;
	}

}
