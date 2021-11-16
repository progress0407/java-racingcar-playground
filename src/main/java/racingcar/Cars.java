package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String input) {
        cars = Arrays.stream(input.split(","))
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
}
