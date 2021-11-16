package racingcar;

import static java.lang.System.out;

public class ApplicationMain {
    public static void main(String[] args) {
        Cars cars = new Cars();
        Prompt prompt = new Prompt(cars);
        prompt.run();
        out.println("cars.getCars() = " + cars.getCars());
    }
}
