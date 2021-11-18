package racingcar;

import java.util.Random;

public class RandomMovingWStrategy implements MovingStrategy {

    @Override
    public boolean isMoving() {
        int randomNumber = getRandomNumber();
        return randomNumber == 1;
    }

    private int getRandomNumber() {
        return new Random().nextInt(2);
    }
}
