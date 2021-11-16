package racingcar;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    Cars cars;

    public Prompt(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String carNames = inputName(scanner);
        int tryNumber = inputTryNumber(scanner);
        scanner.close();
        cars = new Cars(carNames, tryNumber);
        do {
            show(cars);
            cars.move();
        } while (!isGameEnd(cars));
        List<Car> winners = cars.getWinners();
        out.println("winners = " + winners);
    }

    private int inputTryNumber(Scanner scanner) {
        out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private boolean isGameEnd(Cars cars) {
        return cars.isAnyEnd();
    }

    public String inputName(Scanner scanner) {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public void show(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarName(car);
            printMovingLine(car);
        }
    }

    private void printCarName(Car car) {
        out.printf("%5s : ", car.getName());
    }

    private void printMovingLine(Car car) {
        int movingCount = car.getMovingCount();
        for (int i = 0; i < movingCount; i++) {
            out.print("-");
        }
        out.println();
    }
}
