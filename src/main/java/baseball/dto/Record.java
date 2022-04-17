package baseball.dto;

public class Record {
    private int ball;
    private int strike;

    public Record(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
