package fall18_207project.ScoreBoard;


import java.util.Collections;
import java.util.List;

// OperationLarger implements the Strategy class
// The larger the points, the higher the score.
public class OperationLarger implements Strategy {
    @Override
    //the body of doOperation is implemented here
    public void doOperation(List<Score> result) {
        Collections.sort(result);
    }
}
