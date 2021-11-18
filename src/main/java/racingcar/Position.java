package racingcar;

public class Position {
    private int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new RuntimeException("위치는 음수가 올 수 없습니다");
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
