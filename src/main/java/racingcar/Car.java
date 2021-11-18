package racingcar;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position.setValue(position.getValue() + 1);
        }
    }

    public boolean isEnd(int tryNumber) {
        return position.getValue() > tryNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
