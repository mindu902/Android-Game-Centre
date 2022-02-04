package fall18_207project.Simon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;

public class SimonMovementControllerTest {
    private SimonMovementControler mc1;
    private SimonMovementControler mc2;
    private SimonMovementControler mc3;
    private SimonMovementControler mc4;
    private SimonMovementControler mc5;
    private SimonMovementControler mc6;

    @Before
    public void setUp(){
        mc1 = new SimonMovementControler();
        mc2 = new SimonMovementControler();
        mc3 = new SimonMovementControler();
        mc4 = new SimonMovementControler();
        mc5 = new SimonMovementControler();
        mc6 = new SimonMovementControler();

        int array_of_moves[] = new int[1000];
        array_of_moves[0] = 1;
        array_of_moves[1] = 2;
        array_of_moves[2] = 3;
        array_of_moves[3] = 4;
        array_of_moves[4] = 2;
        mc1.array_of_moves = array_of_moves;
        mc2.array_of_moves = array_of_moves;
        mc3.array_of_moves = array_of_moves;
        mc4.array_of_moves = array_of_moves;
        mc6.array_of_moves = array_of_moves;
        mc1.array_of_clicks = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        mc2.array_of_clicks = new ArrayList<Integer>(Arrays.asList(1,2,3,4,2));
        mc3.array_of_clicks = new ArrayList<Integer>(Arrays.asList(1,2,3,4,2,2,3));
        mc4.array_of_clicks = new ArrayList<Integer>(Arrays.asList(1,1,3,4,2));
        mc6.array_of_clicks = new ArrayList<Integer>(Arrays.asList(1,2,3,4,1));
    }

    @After
    public void tearDown() {
        mc1 = null;
        mc2 = null;
        mc3 = null;
        mc4 = null;
    }

    @Test
    public void testConfirm(){
        assertEquals(false, mc1.Confirm());// size too short;
        assertEquals(true, mc2.Confirm()); // same numbers;
        assertEquals(false, mc3.Confirm());//size too long;
        assertEquals(false, mc4.Confirm());// same size but different numbers;
    }

    public void testappendValueToArray(){
        mc5.appendValueToArray();
        assertEquals(0 < mc5.array_of_moves[0] && mc5.array_of_moves[0] < 5,true);
        assertEquals(mc5.array_of_moves[1], 0);
        int num1 = mc5.array_of_moves[0];
        mc5.appendValueToArray();
        assertEquals( mc5.array_of_moves[0], num1); //check the first number remain same;
        assertEquals(0 < mc5.array_of_moves[1] && mc5.array_of_moves[1] < 5,true);
        assertEquals(mc5.array_of_moves[2], 0);

    }

    public void testclear(){
        mc6.clear();
        int nullarray[] = new int[1000];
        ArrayList<Integer> nullarraylist= new ArrayList<Integer>();
        assertEquals(mc6.array_of_moves, nullarray);
        assertEquals(mc6.array_of_clicks, nullarraylist);

    }


}
