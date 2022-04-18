package baseball.model;

import baseball.constant.GameCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReaderTest {
    @DisplayName("플레이어 입력값 유효성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-123", "ab5", "가나다", "''", "7 45", "021", "332", "777"})
    void 플레이어_입력값_유효성_테스트(String given) {
        // then
        assertThatThrownBy(() -> {
            // when
            new Reader(GameCode.BEGINNING).validateIncorrectNumbers(given);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작, 종료 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3", "4", "0", "-1"})
    void 게임_재시작_종료_예외_테스트(String given) {
        // then
        assertThatThrownBy(() -> {
            // when
            new Reader(GameCode.VICTORY).validateOverRangeNumbers(given);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}