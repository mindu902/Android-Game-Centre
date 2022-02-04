package fall18_207project.ScoreBoard;


import java.util.Collections;
import java.util.List;

// OperationSmaller implements the Strategy class
//The smaller the points, the higher the score.
public class OperationSmaller implements Strategy {
    @Override
    public void doOperation(List<Score> result) {
        Collections.sort(result);
        Collections.reverse(result);
    }
}
