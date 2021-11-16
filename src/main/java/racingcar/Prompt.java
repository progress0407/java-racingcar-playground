package racingcar;

import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    Cars cars;

    public Prompt(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        int i = 0;
        String input = input();
        cars = new Cars(input);
        while (true) {
            show(cars);
            cars.move();
            if (i++ > 5) {
                break;
            }
        }
    }

    public String input() {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
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
