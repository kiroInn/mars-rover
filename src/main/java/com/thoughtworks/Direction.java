package com.thoughtworks;

public enum Direction {
    E, S, W, N;

    public Direction turnLeft() {
        return Direction.values()[(ordinal() + 3) % 4];
    }

    public Direction turnRight() {
        return Direction.values()[(ordinal() + 1) % 4];
    }
}
