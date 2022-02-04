package fall18_207project.ScoreBoard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyTest {
    private ScoreBoard sb;

    @Before
    public void setUp() throws Exception {
        sb = new ScoreBoard();
        Score s1 = new Score("aa", 70, 1);
        Score s2 = new Score("aa", 50, 1);
        Score s3 = new Score("aa", 30, 1);
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
        assertEquals("Top 1: 70\n" + "Top 2: 50\n" +  "Top 3: 30\n",
                sb.toString_by_user("aa", 1));
        sb.setStrategy(new OperationSmaller());
        assertEquals("Top 1: 30\n" + "Top 2: 50\n" +  "Top 3: 70\n",
                sb.toString_by_user("aa", 1));
    }
}