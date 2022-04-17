package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class UmpireTest {
    @DisplayName("게임 결과 예외 테스트")
    @Test
    void 게임_결과_예외_테스트() {
        assertThatNullPointerException().isThrownBy(
                () -> {
                    Umpire.getInstance().createMatchRecord(null);
                }
        ).withMessage("경기 결과가 생성되지 않았습니다.");
    }
}