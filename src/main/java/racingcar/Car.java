package racingcar;

public class Car {
    String name;
    int move;

    public Car(String name, int move) {
        validateName(name);
        this.name = name;
        this.move = move;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
