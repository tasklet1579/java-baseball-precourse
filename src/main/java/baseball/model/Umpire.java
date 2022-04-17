package baseball.model;

import baseball.dto.Match;
import baseball.dto.Record;

public class Umpire {
    private static final int PICKED = 1;

    private int[] pitcher;
    private int[] player;
    private int ball;
    private int strike;

    private static Umpire instance = null;

    private Umpire() { }

    public static synchronized Umpire getInstance() {
        if (instance == null) {
            instance = new Umpire();
        }
        return instance;
    }

    public Record createMatchRecord(Match match) {
        if (match == null) {
            throw new NullPointerException("경기 결과가 생성되지 않았습니다.");
        }
        this.pitcher = match.getPitcher();
        this.player = match.getPlayer();
        this.ball = 0;
        this.strike = 0;

        for (int order = 0; order < player.length; order++) {
            checkBall(order);
        }
        return new Record(this.ball, this.strike);
    }

    public void checkBall(int order) {
        int digit = player[order];
        if (pitcher[digit] >= PICKED && pitcher[digit] != order + 1) {
            this.ball += 1;
        }
        if (pitcher[digit] >= PICKED && pitcher[digit] == order + 1) {
            this.strike += 1;
        }
    }
}
