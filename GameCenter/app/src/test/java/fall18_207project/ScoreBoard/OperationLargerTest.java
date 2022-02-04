package fall18_207project.ScoreBoard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationLargerTest {
    private ScoreBoard sb;

    @Before
    public void setUp() throws Exception {
        sb = new ScoreBoard();
        Score s1 = new Score("aa", 70, 0);
        Score s2 = new Score("bb", 50, 0);
        Score s3 = new Score("bb", 30, 0);
        sb.add_score(s1);
        sb.add_score(s2);
        sb.add_score(s3);
    }

    @After
    public void tearDown() throws Exception {
        sb = null;
    }

    @Test
    public void doOperation() {
        sb.setStrategy(new OperationLarger());
        assertEquals("Top 1: aa, 70\n" +
                        "Top 2: bb, 50\n" +
                        "Top 3: bb, 30\n",
                sb.toString_by_game_id(0));
    }


}