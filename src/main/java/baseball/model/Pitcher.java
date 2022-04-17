package baseball.model;

import baseball.dto.Ball;
import camp.nextstep.edu.missionutils.Randoms;

public class Pitcher {
    private static final int COUNT = 3;
    private static final int NUMBER_RANGE = 10;
    private static final int BEGIN_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 9;
    private static final int UNPICKED = 0;

    private int[] balls;
    private int turn;

    private static Pitcher instance = null;

    private Pitcher() { }

    public static synchronized Pitcher getInstance() {
        if (instance == null) {
            instance = new Pitcher();
        }
        return instance;
    }

    public Ball createUniqueBalls() {
        balls = new int[NUMBER_RANGE];
        turn = 1;
        while (turn <= COUNT) {
            int randomBall = Randoms.pickNumberInRange(BEGIN_NUMBER_RANGE, END_NUMBER_RANGE);
            checkDuplicatedBalls(randomBall);
        }
        return new Ball(balls);
    }

    private void checkDuplicatedBalls(int ball) {
        if (balls[ball] == UNPICKED) {
            balls[ball] = turn++;
        }
    }
}
