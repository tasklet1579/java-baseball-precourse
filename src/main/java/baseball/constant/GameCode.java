package baseball.constant;

public enum GameCode {
    BEGINNING(3), RETRY(3), VICTORY(1), START(4), FINISH(5);

    private final int value;

    GameCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
