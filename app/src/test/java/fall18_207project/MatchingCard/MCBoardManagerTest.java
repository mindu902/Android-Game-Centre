package fall18_207project.MatchingCard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fall18_207project.GameCenter.R;
import fall18_207project.MatchingCard.MCBoardManager;

import static org.junit.Assert.*;

public class MCBoardManagerTest {

    private MCBoardManager mcBoardManager;

    public int [] allButtonsGraphicLocation; //random all the location
    public int [] allButtonsGraphics;
    private int step;
    public boolean [] flipOrNotList;

    @Before
    public void setUp() throws Exception {
        mcBoardManager.setSizeOfMat(4);

        mcBoardManager = new MCBoardManager();
    }

    @After
    public void tearDown() throws Exception {
        mcBoardManager = null;
    }

    @Test
    public void shuffleButtonGraphics() {
        mcBoardManager.shuffleButtonGraphics();
        int [] original = mcBoardManager.allButtonsGraphicLocation;
        assertEquals(false, original.equals(allButtonsGraphicLocation));

    }

    @Test
    public void testGetStep() {
        assertEquals(0, mcBoardManager.getStep());
    }

    @Test
    public void testIncreaseStep() {
        mcBoardManager.increaseStep();
        assertEquals(1, mcBoardManager.getStep());
    }

    @Test
    public void putAllButtonsGraphicForEasy() {
        mcBoardManager.setSizeOfMat(2);
        mcBoardManager = new MCBoardManager();
        mcBoardManager.putAllButtonsGraphicForEasy();
        assertEquals(R.drawable.button_1, mcBoardManager.allButtonsGraphics[0]);
        assertEquals(R.drawable.button_2, mcBoardManager.allButtonsGraphics[1]);

    }

    @Test
    public void putAllButtonsGraphicForMedium() {
        mcBoardManager.setSizeOfMat(4);
        System.out.println(mcBoardManager.getSizeOfMat());
        mcBoardManager = new MCBoardManager();
        mcBoardManager.putAllButtonsGraphicForMedium();
        assertEquals(R.drawable.button_1, mcBoardManager.allButtonsGraphics[0]);
        assertEquals(R.drawable.button_2, mcBoardManager.allButtonsGraphics[1]);
        assertEquals(R.drawable.button_3, mcBoardManager.allButtonsGraphics[2]);
        assertEquals(R.drawable.button_4, mcBoardManager.allButtonsGraphics[3]);
        assertEquals(R.drawable.button_5, mcBoardManager.allButtonsGraphics[4]);
        assertEquals(R.drawable.button_6, mcBoardManager.allButtonsGraphics[5]);
        assertEquals(R.drawable.button_7, mcBoardManager.allButtonsGraphics[6]);
        assertEquals(R.drawable.button_8, mcBoardManager.allButtonsGraphics[7]);

    }

    @Test
    public void putAllButtonsGraphicForHard() {
        mcBoardManager.setSizeOfMat(6);
        System.out.println(mcBoardManager.getSizeOfMat());
        mcBoardManager = new MCBoardManager();
        mcBoardManager.putAllButtonsGraphicForHard();
        assertEquals(R.drawable.button_1, mcBoardManager.allButtonsGraphics[0]);
        assertEquals(R.drawable.button_2, mcBoardManager.allButtonsGraphics[1]);
        assertEquals(R.drawable.button_3, mcBoardManager.allButtonsGraphics[2]);
        assertEquals(R.drawable.button_4, mcBoardManager.allButtonsGraphics[3]);
        assertEquals(R.drawable.button_5, mcBoardManager.allButtonsGraphics[4]);
        assertEquals(R.drawable.button_6, mcBoardManager.allButtonsGraphics[5]);
        assertEquals(R.drawable.button_7, mcBoardManager.allButtonsGraphics[6]);
        assertEquals(R.drawable.button_8, mcBoardManager.allButtonsGraphics[7]);
        assertEquals(R.drawable.button_9, mcBoardManager.allButtonsGraphics[8]);
        assertEquals(R.drawable.button_10, mcBoardManager.allButtonsGraphics[9]);
        assertEquals(R.drawable.button_11, mcBoardManager.allButtonsGraphics[10]);
        assertEquals(R.drawable.button_12, mcBoardManager.allButtonsGraphics[11]);
        assertEquals(R.drawable.button_13, mcBoardManager.allButtonsGraphics[12]);
        assertEquals(R.drawable.button_14, mcBoardManager.allButtonsGraphics[13]);
        assertEquals(R.drawable.button_15, mcBoardManager.allButtonsGraphics[14]);
        assertEquals(R.drawable.button_16, mcBoardManager.allButtonsGraphics[15]);
        assertEquals(R.drawable.button_17, mcBoardManager.allButtonsGraphics[16]);
        assertEquals(R.drawable.button_18, mcBoardManager.allButtonsGraphics[17]);


    }
}