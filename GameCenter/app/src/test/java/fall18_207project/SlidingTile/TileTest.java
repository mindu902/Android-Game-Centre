package fall18_207project.SlidingTile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fall18_207project.GameCenter.R;
import fall18_207project.SlidingTile.Tile;

import static org.junit.Assert.*;

public class TileTest {
    Tile tile1;
    Tile tile2;
    Tile tileRandom;

    @Before
    public void setUp() throws Exception {
        tile1 = new Tile(1, 0);
        tile2 = new Tile(1); //id = 2

    }

    @After
    public void tearDown() throws Exception {
        tile1 = null;
        tile2 = null;

    }

    @Test
    public void testGetBackground() {
        assertEquals(0, tile1.getBackground());

        tileRandom = new Tile(0);
        assertEquals(R.drawable.tile_1, tileRandom.getBackground());

        tileRandom = new Tile(1);
        assertEquals(R.drawable.tile_2, tileRandom.getBackground());

        tileRandom = new Tile(2);
        assertEquals(R.drawable.tile_3, tileRandom.getBackground());

        tileRandom = new Tile(3);
        assertEquals(R.drawable.tile_4, tileRandom.getBackground());

        tileRandom = new Tile(4);
        assertEquals(R.drawable.tile_5, tileRandom.getBackground());

        tileRandom = new Tile(5);
        assertEquals(R.drawable.tile_6, tileRandom.getBackground());

        tileRandom = new Tile(6);
        assertEquals(R.drawable.tile_7, tileRandom.getBackground());

        tileRandom = new Tile(7);
        assertEquals(R.drawable.tile_8, tileRandom.getBackground());

        tileRandom = new Tile(8);
        assertEquals(R.drawable.tile_9, tileRandom.getBackground());

        tileRandom = new Tile(9);
        assertEquals(R.drawable.tile_10, tileRandom.getBackground());

        tileRandom = new Tile(10);
        assertEquals(R.drawable.tile_11, tileRandom.getBackground());

        tileRandom = new Tile(11);
        assertEquals(R.drawable.tile_12, tileRandom.getBackground());

        tileRandom = new Tile(13);
        assertEquals(R.drawable.tile_14, tileRandom.getBackground());

        tileRandom = new Tile(14);
        assertEquals(R.drawable.tile_15, tileRandom.getBackground());

        tileRandom = new Tile(15);
        assertEquals(R.drawable.tile_16, tileRandom.getBackground());

        tileRandom = new Tile(16);
        assertEquals(R.drawable.tile_17, tileRandom.getBackground());

        tileRandom = new Tile(17);
        assertEquals(R.drawable.tile_18, tileRandom.getBackground());

        tileRandom = new Tile(18);
        assertEquals(R.drawable.tile_19, tileRandom.getBackground());

        tileRandom = new Tile(19);
        assertEquals(R.drawable.tile_20, tileRandom.getBackground());

        tileRandom = new Tile(20);
        assertEquals(R.drawable.tile_21, tileRandom.getBackground());

        tileRandom = new Tile(21);
        assertEquals(R.drawable.tile_22, tileRandom.getBackground());

        tileRandom = new Tile(22);
        assertEquals(R.drawable.tile_23, tileRandom.getBackground());

        tileRandom = new Tile(23);
        assertEquals(R.drawable.tile_24, tileRandom.getBackground());

        tileRandom = new Tile(24);
        assertEquals(R.drawable.tile_blank, tileRandom.getBackground());
    }

    @Test
    public void testGetId() {
        assertEquals(1, tile1.getId());
        assertEquals(2, tile2.getId());
    }

    @Test
    public void testCompareTo() {
        assertEquals(1, tile1.compareTo(tile2));
    }
}