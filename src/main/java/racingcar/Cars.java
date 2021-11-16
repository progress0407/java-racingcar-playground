package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private int tryNumber;
    private List<Car> cars;

    public Cars() {

    }

    public Cars(String carNames, int tryNumber) {
        this.tryNumber = tryNumber;
        cars = Arrays.stream(carNames.split(","))
                .map(carName -> new Car(carName, 1))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    // 자동차를 일제히 움직인다
    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public boolean isAnyEnd() {
        for (Car car : cars) {
            if (car.isEnd(tryNumber)) {
                return true;
            }
        }
        return false;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.isEnd(tryNumber))
                .collect(Collectors.toList());
    }
}
