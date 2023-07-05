package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int collumns) {
		if (rows < 1 || collumns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = collumns;
		pieces = new Piece[rows][collumns];

	}

	public int getRows() {
		return rows;
	}

	public int getCollumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {	throw new BoardException("Position mot on the board");
			
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
if (!positionExists(position)) {	throw new BoardException("Position mot on the board");
			
		}
		return pieces[position.getRow()][position.getCollumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already piece on position" + position);
		}
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;

	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollumn());

	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {	throw new BoardException("Position mot on the board");
		
		}
		return piece(position) != null;
	}

}
