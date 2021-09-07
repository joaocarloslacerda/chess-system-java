package boardgame;

public class Position {
	
	//atributos da classe
	private int row;
	private int column;
	
	//criando construtor personalizado tendo como parâmetro os atributos row e column
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	//retorna o atributo row
	public int getRow() {
		return row;
	}
	
	//seta um valor para row
	public void setRow(int row) {
		this.row = row;
	}
	
	//retorna o atributo column
	public int getColumn() {
		return column;
	}
	
	//seta um valor para column
	public void setColumn(int column) {
		this.column = column;
	}
	
	//atualizando os valores de uma posição
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	//printando o valor no atributo row e column
	public String toString() {
		return row + ", " + column;
	}
	

}
