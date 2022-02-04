package fall18_207project.SlidingTile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fall18_207project.SlidingTile.Board;
import fall18_207project.SlidingTile.Tile;

import static org.junit.Assert.*;

public class BoardTest {

    private Board bd;


    @Before
    public void setUp()  {
        Tile T1 = new Tile(1);
        Tile T2 = new Tile(2);
        Tile T3 = new Tile(3);
        Tile T4 = new Tile(4);
        Tile T5 = new Tile(5);
        Tile T6 = new Tile(6);
        Tile T7 = new Tile(7);
        Tile T8 = new Tile(8);
        Tile T9 = new Tile(9);
        List<Tile> tiles = new ArrayList<>();
        tiles.add(T1);
        tiles.add(T2);
        tiles.add(T3);
        tiles.add(T4);
        tiles.add(T5);
        tiles.add(T6);
        tiles.add(T7);
        tiles.add(T8);
        tiles.add(T9);
        bd.NUM_ROWS = 3;
        bd.NUM_COLS = 3;

        bd = new Board(tiles);

    }

    @After
    public void tearDown() {bd = null;
    }

    @Test
    public void numTiles() {assertEquals(9, bd.numTiles());
    }

    @Test
    public void getTile() {assertEquals("Tile9", bd.getTile(2,2).toString());
    }

    @Test

    public void swapTiles() {bd.swapTiles(0,0,2,2);
        assertEquals("Tile9", bd.getTile(0,0).toString());

    }

    @Test
    public void iterator() {
        assertTrue(bd.iterator().hasNext());
        assertEquals(2,bd.iterator().next().getId());
    }

    @Test
    public void testToString() {
        String result =  bd.toString();

        assertEquals(result,bd.toString());
    }


}