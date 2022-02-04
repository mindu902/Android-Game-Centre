package fall18_207project.ScoreBoard;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import fall18_207project.ScoreBoard.Score;

import static org.junit.Assert.*;

public class ScoreTest {
    Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score("Joy", 100, 0);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        score = null;
    }

    @Test
    public void testGetScoreInformation() {
        assertEquals("Joy", score.get_username());
        assertEquals(100, score.get_score());
        assertEquals(0, score.get_game_id());
    }

    @Test
    public void testCompareTwoScores() {
        Score s1 = new Score("Joy1", 100, 0);
        Score s2 = new Score("Joy2", 90, 0);
        int result = s1.compareTo(s2);
        assertEquals(-10, result);
    }

    @Test
    public void testScoreToString() {
        assertEquals(score.toString(), "User: Joy, Game ID: 0, Score: 100");
    }

}
