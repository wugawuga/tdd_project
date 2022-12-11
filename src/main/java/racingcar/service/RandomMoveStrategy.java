package racingcar.service;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_MAXIMUM_BOUND = 9;
    private static final int MOVE_CONDITION = 4;
    private final Random random = new Random();

    @Override
    public boolean movable() {
        return random.nextInt(RANDOM_MAXIMUM_BOUND) >= MOVE_CONDITION;
    }
}
