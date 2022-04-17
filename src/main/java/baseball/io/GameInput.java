package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    private static GameInput instance = null;

    private GameInput() { }

    public static synchronized GameInput getInstance() {
        if (instance == null) {
            instance = new GameInput();
        }
        return instance;
    }

    public String readInputValue() {
        return Console.readLine();
    }
}
