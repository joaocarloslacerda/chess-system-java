package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//cria construtor personalizado, que apenas passa para a super classe o board e o color
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//informando que o m�todo est� sendo sobreposto
	@Override
	//printando a letra que corresponde a pe�a ROOK
	public String toString() {
		return "R";
	}
	
	//metodo que retorna os poss�veis movimentos de uma pe�a para o m�todo possbleMovie
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//instancindo atributo auxiliar
		Position p = new Position(0,0);
		
		//ABOVE
		//atualizando para a linha anterior a da pe�a
		p.setValues(position.getRow() - 1, position.getColumn());
		//faz o loop enquanto existir uma posi��o e enquanto n�o existir uma pe�a advers�ria
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a para ela
			mat[p.getRow()][p.getColumn()] = true;
			//atualiza para a linha anterior
			p.setRow(p.getRow() - 1);
		}
		//verifica se existe uma posi��o seguinte a �ltima em que o loop anterior parou e se a pe�a encontrada � uma pe�a oponente
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a para ela
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//LEFT
		//atualizando para a coluna anterior a da pe�a
		p.setValues(position.getRow(), position.getColumn() - 1);
		//faz o loop enquanto existir uma posi��o e enquanto n�o existir uma pe�a advers�ria
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a para ela
			mat[p.getRow()][p.getColumn()] = true;
			//atualiza para a coluna anterior
			p.setColumn(p.getColumn() - 1);
		}
		//verifica se existe uma posi��o seguinte a �ltima em que o loop anterior parou e se a pe�a encontrada � uma pe�a oponente
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a paa ela
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//RIGHT
		//atualizando para a coluna seguinte a da pe�a
		p.setValues(position.getRow(), position.getColumn() + 1);
		//faz o loop enquanto existir uma posi��o e enquanto n�o existir uma pe�a advers�ria
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a paa ela
			mat[p.getRow()][p.getColumn()] = true;
			//atualiza para a coluna seguinte
			p.setColumn(p.getColumn() + 1);
		}
		//verifica se existe uma posi��o seguinte a �ltima em que o loop anterior parou e se a pe�a encontrada � uma pe�a oponente
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a paa ela
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//BELOW
		//atualizando para a linha seguinte a da pe�a
		p.setValues(position.getRow() + 1, position.getColumn());
		//faz o loop enquanto existir uma posi��o e enquanto n�o existir uma pe�a advers�ria
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a para ela
			mat[p.getRow()][p.getColumn()] = true;
			//atualiza para a linha seguinte
			p.setRow(p.getRow() + 1);
		}
		//verifica se existe uma posi��o seguinte a �ltima em que o loop anterior parou e se a pe�a encontrada � uma pe�a oponente
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//marcando a posi��o como true indicando que pode movimentar a pe�a para ela
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
