package fall18_207project.ScoreBoard;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

import fall18_207project.ScoreBoard.OperationLarger;
import fall18_207project.ScoreBoard.Score;
import fall18_207project.ScoreBoard.ScoreBoard;


public class ScoreBoardTest {
    private ScoreBoard sb;

    @Before
    public void setUp() {
        sb = new ScoreBoard();
        Score s1 = new Score("Joy1", 100, 0);
        Score s2 = new Score("Joy1", 90, 0);
        Score s3 = new Score("Joy2", 80, 0);
        sb.add_score(s1);
        sb.add_score(s2);
        sb.add_score(s3);
        sb.setStrategy(new OperationLarger());
    }

    @After
    public void tearDown() {
        sb = null;
    }

    @Test
    public void testAddScore() {
        assertEquals(3, sb.scores.size());
    }

    @Test
    public void testGetScoreByUser() {
        assertEquals("User: Joy1, Game ID: 0, Score: 100",
                sb.get_scores_by_user("Joy1", 0).get(0).toString());
        assertEquals("User: Joy1, Game ID: 0, Score: 90",
                sb.get_scores_by_user("Joy1", 0).get(1).toString());
    }

    @Test
    public void testGetScoreByGameID() {
        assertEquals("User: Joy1, Game ID: 0, Score: 100",
                sb.get_scores_by_game_id(0).get(0).toString());
        assertEquals("User: Joy1, Game ID: 0, Score: 90",
                sb.get_scores_by_game_id(0).get(1).toString());
        assertEquals("User: Joy2, Game ID: 0, Score: 80",
                sb.get_scores_by_game_id(0).get(2).toString());

    }

    @Test
    public void testGetScoreByUserToString() {
        assertEquals("Top 1: 100\n" + "Top 2: 90\n",
                sb.toString_by_user("Joy1", 0));
    }

    @Test
    public void testGetScoreByGameIDToString() {
        assertEquals("Top 1: Joy1, 100\n" +
                        "Top 2: Joy1, 90\n" +
                        "Top 3: Joy2, 80\n",
                sb.toString_by_game_id(0));
    }


}