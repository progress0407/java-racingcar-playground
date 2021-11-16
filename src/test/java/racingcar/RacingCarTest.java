package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    /**
     * pobi,crong,honux
     */
    @Test
    @DisplayName("자동차 생성 로직")
    void 자동차생성() {
        Cars cars = new Cars("pobi,crong,honux");
        int carsCount = cars.getCars().size();
        assertThat(carsCount).isEqualTo(3); // 자동차는 총 세대
        // 첫 생성시 움직인 횟수는 모두 1회
        for (Car car : cars.getCars()) {
            assertThat(car.getMovingCount()).isEqualTo(1);
        }
    }
    
    @Test
    @DisplayName("자동차 이름은 5자 이상을 초과할 수 없습니다")
    void 차이름_예외처리() {
        assertThatThrownBy(() -> {
            new Cars("pobi,crong,honuxx");
        }).isInstanceOf(RuntimeException.class);
    }
}
