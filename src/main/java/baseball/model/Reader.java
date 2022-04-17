package baseball.model;

import baseball.constant.GameCode;

public class Reader {
    private static final String MINUS = "-";
    private static final String ZERO = "0";
    private static final int BEGIN_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 2;

    private int numberLength;

    public Reader(GameCode gameCode) {
        this.numberLength = gameCode.getValue();
    }

    public void validateIncorrectNumbers(String numbers) {
        if (numbers.contains(MINUS)) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해주세요.");
        }
        if (numbers.contains(ZERO)) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해주세요.");
        }
        if (numbers.length() != numberLength) {
            throw new IllegalArgumentException("허용되지 않는 숫자 길이입니다.");
        }
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateOverRangeNumbers(String number) {
        if (Integer.parseInt(number) < BEGIN_NUMBER_RANGE || Integer.parseInt(number) > END_NUMBER_RANGE) {
            throw new IllegalArgumentException("게임 재시작, 종료 외에는 지원하지 않는 명령입니다.");
        }
    }
}
