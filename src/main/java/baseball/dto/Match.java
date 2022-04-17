package baseball.dto;

public class Match {
    private int[] pitcher;
    private int[] player;

    public Match(int[] pitcher, char[] player) {
        this.pitcher = pitcher;
        this.player = new int[player.length];
        getNumericValue(player);
    }

    private void getNumericValue(char[] player) {
        for (int idx = 0; idx < player.length; idx++) {
            this.player[idx] = Character.getNumericValue(player[idx]);
        }
    }

    public int[] getPitcher() {
        return pitcher;
    }

    public int[] getPlayer() {
        return player;
    }
}
