package baseball.controller;

import baseball.constant.GameCode;
import baseball.dto.Ball;
import baseball.dto.Match;
import baseball.dto.Record;
import baseball.io.GameInput;
import baseball.io.GameOutput;
import baseball.io.Message;
import baseball.model.Pitcher;
import baseball.model.Reader;
import baseball.model.Umpire;

public class GameLauncher {
    private static final GameInput input = GameInput.getInstance();
    private static final GameOutput output = GameOutput.getInstance();
    private static final Pitcher pitcher = Pitcher.getInstance();
    private static final Umpire umpire = Umpire.getInstance();

    private static final String RETRY = "1";
    private static final String FINISH = "2";

    private static GameCode gameCode = GameCode.START;

    public static void start() {
        while (isFinished()) {
            isRetry();
            playBall(pitcher.createUniqueBalls());
        }
    }

    public static boolean isFinished() {
        if (gameCode == GameCode.FINISH) {
            return false;
        }
        return true;
    }

    public static void isRetry() {
        if (gameCode == GameCode.RETRY) {
            gameCode = GameCode.START;
        }
    }

    public static boolean retry() {
        if (gameCode == GameCode.RETRY || gameCode == GameCode.FINISH) {
            return false;
        }
        return true;
    }

    public static void playBall(Ball balls) {
        while (retry()) {
            Message message = new Message();
            output.printOutputMessage(message);

            String inputNumbers = input.readInputValue();

            Reader reader = new Reader(message.getStatus());
            reader.validateIncorrectNumbers(inputNumbers);

            Record record = umpire.createMatchRecord(new Match(balls.getBalls(), inputNumbers.toCharArray()));

            Message result = new Message(record.getStrike(), record.getBall());
            output.printOutputMessage(result);

            isPlayerVictory(result);
        }
    }

    public static void isPlayerVictory(Message message){
        if (message.getStatus() == GameCode.VICTORY) {
            String value = input.readInputValue();
            Reader reader = new Reader(message.getStatus());
            reader.validateIncorrectNumbers(value);
            reader.validateOverRangeNumbers(value);
            willPlayerWantOneMoreGame(value);
        }
    }

    public static void willPlayerWantOneMoreGame(String value) {
        if (value.startsWith(RETRY)) {
            gameCode = GameCode.RETRY;
        }
        if (value.startsWith(FINISH)) {
            gameCode = GameCode.FINISH;
        }
    }
}
