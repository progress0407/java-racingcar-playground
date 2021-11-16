package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int movingCount;

    public Car(String name, int movingCount) {
        validateName(name);
        this.name = name;
        this.movingCount = movingCount;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move() {
        if (isMoving()) {
            movingCount += 1;
        }
    }

    public boolean isEnd(int tryNumber) {
        return movingCount > tryNumber;
    }

    private boolean isMoving() {
        int randomNumber = getRandomNumber();
        return randomNumber == 1;
    }

    private int getRandomNumber() {
        return new Random().nextInt(2);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", movingCount=" + movingCount +
                '}';
    }
}
