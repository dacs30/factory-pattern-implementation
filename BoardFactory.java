/**
 * The implementation applies the Singleton pattern and uses lazy instantiation
 * of the
 * single factory object.
 */
public class BoardFactory {
    private static BoardFactory theFactory = null;

    private BoardFactory() {
        // default private constructor
    }

    public static BoardFactory getInstance() {
        // getInstance is a common name for the method
        if (theFactory == null) {
            theFactory = new BoardFactory();
        }
        return theFactory;
    }

    // Since we have different attributes, we just name the methods according
    // to the board type. We really don't need the GameType.
    public Board makeChessBoard() {
        return new ChessBoard();
    }

    public Board makeGoBoard() {
        return new GoBoard();
    }

    public Board makeMultiDimensionalChessBoard(int numberOfDimensions) {
        return new MultiDimensionalChessBoard(numberOfDimensions);
    }

    public Board makeEscapePlusBoard(int numberOfDimensions, int numberOfPlayers) {
        return new EscapePlusBoard(numberOfDimensions, numberOfPlayers);
    }

    public static void main(String [] args){
        BoardFactory factory = BoardFactory.getInstance();  
        Board board = factory.makeGoBoard();
        System.out.println("The class of the board is: " + board.getClass().getName());
        board = factory.makeChessBoard();
        System.out.println("The class of the board is: " + board.getClass().getName());
        Board board2 = factory.makeMultiDimensionalChessBoard(3);
        System.out.println("The class of the board is: " + board2.getClass().getName());
        board2 = factory.makeEscapePlusBoard(2, 4);
        System.out.println("The class of the board is: " + board2.getClass().getName());
    }
}
