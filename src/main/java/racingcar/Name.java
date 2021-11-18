package racingcar;

public class Name {

    public String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
