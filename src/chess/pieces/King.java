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
	
	//informando que o m�todo est� sendo sobreposto
	@Override
	//printando a letra que corresponde a pe�a KING
	public String toString() {
		return "K";
	}
	
	//m�todo que verifica se a pe�a pode ser movimentada
	private boolean canMove(Position position) {
		//pegando a pe�a que est� na posi��o passada por par�metro
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//retorna p se a posi��o estiver vazia ou se a cor da pe�a n�o for igual a pe�a a ser movimentada, ou seja se for uma pe�a advers�ria
		return p == null || p.getColor() != getColor();
	}

	//metodo que retorna os poss�veis movimentos de uma pe�a para o m�todo possbleMovie
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//criando uma vari�vel auxiliar e que come�a
		Position p = new Position(0,0);
		
		//above
		//atualizando os valores da posi��o para a linha anterior da pe�a
		p.setValues(position.getRow() - 1, position.getColumn());
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below
		//atualizando os valores da posi��o para a pr�xima linha da pe�a
		p.setValues(position.getRow() + 1, position.getColumn());
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		//atualizando os valores da posi��o para a coluna anterior da pe�a
		p.setValues(position.getRow(), position.getColumn() - 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		//atualizando os valores da posi��o para a pr�xima coluna da pe�a
		p.setValues(position.getRow(), position.getColumn() + 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//nw
		//atualizando os valores da posi��o para a linha e a coluna anterior da pe�a
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//ne
		//atualizando os valores da posi��o para a linha anterior e a pr�cima coluna da pe�a
		p.setValues(position.getRow() - 1 , position.getColumn() + 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//sw
		//atualizando os valores da posi��o para a pr�xima linha e a coluna anterior da pe�a
		p.setValues(position.getRow() + 1 , position.getColumn() - 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//se
		//atualizando os valores da posi��o para a pr�xima linha e a pr�xima coluna da pe�a
		p.setValues(position.getRow() + 1 , position.getColumn() + 1);
		//verifica se a posi��o existe no tabuleiro e se � permitido movimentar a pe�a para ela
		if(getBoard().positionExists(p) && canMove(p)){
			//se a posi��o existe e � permitido movimentar a pe�a para ela, a mesma � marcada como true
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		
		return mat;
	}

}
