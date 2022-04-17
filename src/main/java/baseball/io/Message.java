package baseball.io;

import baseball.constant.GameCode;

public class Message {
    private static final String BASEBALL_PLEASE_ENTER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String BASEBALL_BALL = "%d볼\n";
    private static final String BASEBALL_STRIKE = "%d스트라이크\n";
    private static final String BASEBALL_BALL_STRIKE = "%d볼 %d스트라이크\n";
    private static final String BASEBALL_NOTHING = "낫싱\n";
    private static final String BASEBALL_YOU_GOT_ALL_NUMBERS_RIGHT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                                                                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private String message;
    private GameCode status = GameCode.BEGINNING;

    public Message() {
        this.message = BASEBALL_PLEASE_ENTER_NUMBERS;
    }

    public Message(int strike, int ball) {
        this.message = BASEBALL_NOTHING;
        this.status = GameCode.RETRY;

        if (strike >= 1 && ball >= 1) {
            this.message = String.format(BASEBALL_BALL_STRIKE, ball, strike);
        }
        if (strike >= 1 && ball == 0) {
            this.message = String.format(BASEBALL_STRIKE, strike);
        }
        if (strike == 0 && ball >= 1) {
            this.message = String.format(BASEBALL_BALL, ball);
        }
        if (strike == 3) {
            this.message = String.format(BASEBALL_STRIKE, strike) + BASEBALL_YOU_GOT_ALL_NUMBERS_RIGHT;
            this.status = GameCode.VICTORY;
        }
    }

    public String getMessage() {
        return message;
    }

    public GameCode getStatus() {
        return status;
    }
}
