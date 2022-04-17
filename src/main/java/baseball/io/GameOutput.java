package baseball.io;

public class GameOutput {
    private static GameOutput instance = null;

    private GameOutput() { }

    public static synchronized GameOutput getInstance() {
        if (instance == null) {
            instance = new GameOutput();
        }
        return instance;
    }

    public void printOutputMessage(Message message) {
        System.out.print(message.getMessage());
    }
}
