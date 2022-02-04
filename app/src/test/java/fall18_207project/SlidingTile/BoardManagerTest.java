package fall18_207project.SlidingTile;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall18_207project.SlidingTile.Board;
import fall18_207project.SlidingTile.BoardManager;
import fall18_207project.SlidingTile.Tile;

import static org.junit.Assert.assertEquals;

public class BoardManagerTest {
    /** The board manager for testing. */
    BoardManager boardManager1;
    BoardManager boardManager2;
    /**
     * Make a set of tiles that are in order.
     * @return a set of tiles that are in order
     */
    private List<Tile> makeTiles() {
        List<Tile> tiles = new ArrayList<>();
        Board.setNumCols(4);
        Board.setNumRows(4);
        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles - 1; tileNum++) {
            tiles.add(new Tile(tileNum + 1, tileNum));
        }
        tiles.add(new Tile(25, 24));
        return tiles;
    }

    /**
     * Make a solved Board.
     */
    private void setUpCorrect() {
        List<Tile> tiles = makeTiles();
        Board board = new Board(tiles);
        boardManager1 = new BoardManager(board);
    }

    @Test
    public void testGetBoard1() {
        List<Tile> tiles = makeTiles();
        Board board = new Board(tiles);
        boardManager1 = new BoardManager(board);
        assertEquals(board, boardManager1.getBoard());
    }


    @Test
    public void testGetStep() {
        setUpCorrect();
        assertEquals(0, boardManager1.getStep());
    }

    @Test
    public void testGetUndoList() {
        setUpCorrect();
        ArrayList<Integer> testList = new ArrayList();
        assertEquals(testList, boardManager1.getUndoList());
    }

    @Test
    public void testPuzzleSolved() {
        setUpCorrect();
        assertEquals(true, boardManager1.puzzleSolved());

        boardManager1.getBoard().swapTiles(0, 0, 0, 1);
        assertEquals(false, boardManager1.puzzleSolved());

    }

    @Test
    public void testIsValidTap() {
        setUpCorrect();
        assertEquals(true, boardManager1.isValidTap(11));
        assertEquals(true, boardManager1.isValidTap(14));
        assertEquals(false, boardManager1.isValidTap(10));
    }

    @Test
    public void testTouchMove() {
        setUpCorrect();
        boardManager1.touchMove(11);
        ArrayList<Integer> testUndoList = new ArrayList();
        testUndoList.add(2);
        testUndoList.add(3);
        testUndoList.add(3);
        testUndoList.add(3);
        assertEquals(testUndoList, boardManager1.getUndoList());

        boardManager1.touchMove(5);
        assertEquals(testUndoList, boardManager1.getUndoList());

        boardManager1.touchMove(12);
        assertEquals(testUndoList, boardManager1.getUndoList());

        boardManager1.touchMove(10);
        testUndoList.add(2);
        testUndoList.add(2);
        testUndoList.add(2);
        testUndoList.add(3);
        assertEquals(testUndoList, boardManager1.getUndoList());

    }
    @Test
    public void testTouchMovePrepare() {
        setUpCorrect();

        assertEquals(15, boardManager1.getBoard().getTile(3, 2).getId());
        assertEquals(25, boardManager1.getBoard().getTile(3, 3).getId());
        boardManager1.touchMovePrepare(14);
        assertEquals(25, boardManager1.getBoard().getTile(3, 2).getId());
        assertEquals(15, boardManager1.getBoard().getTile(3, 3).getId());
    }

    @Test
    public void testUnDo() {
        setUpCorrect();
        ArrayList<Integer> testUndoList = new ArrayList();
        testUndoList.add(2);
        testUndoList.add(3);
        testUndoList.add(3);
        testUndoList.add(3);
        boardManager1.touchMove(11);
        boardManager1.touchMove(10);
        boardManager1.touchMove(6);
        boardManager1.touchMove(2);

        boardManager1.unDo();
        assertEquals(testUndoList, boardManager1.getUndoList());

    }

    @Test
    public void testUnDoNSteps() {setUpCorrect();
        ArrayList<Integer> testUndoList = new ArrayList();
        boardManager1.touchMove(14);
        boardManager1.unDoNSteps(1);
        assertEquals(testUndoList, boardManager1.getUndoList());

        boardManager1.touchMove(14);
        testUndoList.add(3);
        testUndoList.add(2);
        testUndoList.add(3);
        testUndoList.add(3);

        boardManager1.touchMove(10);
        testUndoList.add(2);
        testUndoList.add(2);
        testUndoList.add(3);
        testUndoList.add(2);

        boardManager1.touchMove(9);
        boardManager1.touchMove(8);
        boardManager1.touchMove(4);
        boardManager1.touchMove(1);
        boardManager1.touchMove(0);

        boardManager1.unDoNSteps(4);

        assertEquals(testUndoList, boardManager1.getUndoList());


    }

    @Test
    public void testIsValidUndo() {
        setUpCorrect();
        boardManager1.touchMove(14);
        assertEquals(false, boardManager1.isValidUndo());
        boardManager1.touchMove(13);
        boardManager1.touchMove(12);
        assertEquals(true, boardManager1.isValidUndo());

        boardManager1.unDo();
        assertEquals(false, boardManager1.isValidUndo());
        boardManager1.touchMove(0);
        boardManager1.touchMove(1);
        boardManager1.touchMove(2);
        boardManager1.touchMove(3);
        boardManager1.touchMove(4);
        assertEquals(false, boardManager1.isValidUndo());
    }

    @Test
    public void isValidUndoNSteps() {
        setUpCorrect();
        boardManager1.touchMove(14);
        assertEquals(true, boardManager1.isValidUndoNSteps(1));
        assertEquals(false, boardManager1.isValidUndoNSteps(2));
        boardManager1.touchMove(13);
        boardManager1.touchMove(12);
        assertEquals(true, boardManager1.isValidUndoNSteps(2));
        assertEquals(false, boardManager1.isValidUndoNSteps(4));

        boardManager1.unDoNSteps(1);
        boardManager1.touchMove(9);
        boardManager1.touchMove(5);
        boardManager1.touchMove(6);
        assertEquals(true, boardManager1.isValidUndoNSteps(5));
        assertEquals(false, boardManager1.isValidUndoNSteps(6));

    }
}