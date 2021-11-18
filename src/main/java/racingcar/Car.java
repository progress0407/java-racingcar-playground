package racingcar;

public class Car {
    private final Name name;
    private int position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
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
