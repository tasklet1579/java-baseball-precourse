package baseball.controller;

import baseball.dto.Match;
import baseball.dto.Record;
import baseball.io.Message;
import baseball.model.Umpire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameLauncherTest {
    @DisplayName("ONE 볼 카운팅 테스트")
    @Test
    void ONE_볼_카운팅_테스트() {
        // given
        String expected = "1볼";

        // when
        int[] pitcher = {0, 1, 2, 3, 0, 0, 0, 0, 0, 0};
        char[] player = {'2', '4', '5'};
        Record record = Umpire.getInstance().createMatchRecord(new Match(pitcher, player));
        Message result = new Message(record.getStrike(), record.getBall());

        // then
        assertThat(result.getMessage()).contains(expected);
    }

    @DisplayName("THREE 볼 카운팅 테스트")
    @Test
    void THREE_볼_카운팅_테스트() {
        // given
        String expected = "3볼";

        //
        int[] pitcher = {0, 1, 2, 3, 0, 0, 0, 0, 0, 0};
        char[] player = {'2', '3', '1'};
        Record record = Umpire.getInstance().createMatchRecord(new Match(pitcher, player));
        Message result = new Message(record.getStrike(), record.getBall());

        // then
        assertThat(result.getMessage()).contains(expected);
    }

    @DisplayName("TWO 스트라이크 카운팅 테스트")
    @Test
    void TWO_스트라이크_카운팅_테스트() {
        // given
        String expected = "2스트라이크";

        //
        int[] pitcher = {0, 0, 0, 3, 0, 1, 2, 0, 0, 0};
        char[] player = {'5', '6', '1'};
        Record record = Umpire.getInstance().createMatchRecord(new Match(pitcher, player));
        Message result = new Message(record.getStrike(), record.getBall());

        // then
        assertThat(result.getMessage()).contains(expected);
    }

    @DisplayName("낫싱 테스트")
    @Test
    void 낫싱_테스트() {
        // given
        String expected = "낫싱";

        //
        int[] pitcher = {0, 0, 0, 3, 0, 0, 2, 0, 0, 1};
        char[] player = {'1', '2', '8'};
        Record record = Umpire.getInstance().createMatchRecord(new Match(pitcher, player));
        Message result = new Message(record.getStrike(), record.getBall());

        // then
        assertThat(result.getMessage()).contains(expected);
    }
}