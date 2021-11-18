package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position += 1;
        }
    }

    public boolean isEnd(int tryNumber) {
        return position > tryNumber;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
