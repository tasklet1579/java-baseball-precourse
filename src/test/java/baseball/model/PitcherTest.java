package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PitcherTest {
    @DisplayName("서로 다른 숫자 3개를 선택하는지 테스트")
    @Test
    void 서로_다른_숫자_3개를_선택하는지_테스트() {
        // given
        int[] expected = {1, 2, 3};
        int expectedLength = 3;

        // when
        List<Integer> turns = new LinkedList<>();

        for (int turn : Pitcher.getInstance().createUniqueBalls().getBalls()) {
            if (turn > 0) {
                turns.add(turn);
            }
        }

        Collections.sort(turns);

        int[] actual = new int[turns.size()];
        int idx = 0;
        for (int turn : turns) {
            actual[idx++] = turn;
        }

        // then
        assertThat(actual.length).isEqualTo(expectedLength);

        // then
        assertThat(turns.toString()).isEqualTo(Arrays.toString(expected));

        // then
        assertThat(actual).containsExactly(expected);
    }
}