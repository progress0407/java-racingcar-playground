package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 이동을 한다")
    void 차_이동() {
        Car car = new Car("foo");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는다")
    void 차_멈춤() {
        Car car = new Car("foo");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 생성 로직")
    void 자동차생성() {
        Cars cars = new Cars("pobi,crong,honux", 5);
        int carsCount = cars.getCars().size();
        assertThat(carsCount).isEqualTo(3); // 자동차는 총 세대
        // 첫 생성시 움직인 횟수는 모두 1회
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("자동차 이름은 5자 이상을 초과할 수 없습니다")
    void 차이름_예외처리() {
        assertThatThrownBy(() -> new Cars("pobi,crong,honuxx", 5)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("위치는 음수일 수 없습니다")
    void 위치_예외처리() {
        assertThatThrownBy(() -> new Car("philo", -1));
    }

    @Test
    @DisplayName("우승자가 한명: pobi")
    void 한명_우승자() {
        //pobi,crong,honux
        Car pobi = new Car("pobi", 1);
        Car crong = new Car("crong", 1);
        Car honux = new Car("honux", 1);

        Cars cars = new Cars(new ArrayList<>(Arrays.asList(pobi, crong, honux)), 5);
        pobi.move(5);
        crong.move(2);
        honux.move(3);
        assertThat(cars.getWinners()).containsExactly(pobi);
    }

    @Test
    @DisplayName("우승자가 여러명: pobi, honux")
    void 여러_우승자() {
        //pobi,crong,honux
        Car pobi = new Car("pobi", 1);
        Car crong = new Car("crong", 1);
        Car honux = new Car("honux", 1);

        Cars cars = new Cars(new ArrayList<>(Arrays.asList(pobi, crong, honux)), 5);
        pobi.move(5);
        crong.move(4);
        honux.move(5);
        assertThat(cars.getWinners()).containsExactly(pobi, honux);
    }
}
