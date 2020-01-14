package com.thoughtworks;

import java.util.List;

class Rover {
    private Position pointer;
    private Direction direction;

    Rover(Position pointer, Direction direction) {
        this.setPointer(pointer);
        this.setDirection(direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position getPointer() {
        return pointer;
    }

    public void setPointer(Position pointer) {
        this.pointer = pointer;
    }

    public String execute(List<Instruction> instructions) {
        if (null != instructions) {
            instructions.forEach(instruction -> {
                if (instruction.equals(Instruction.L)) {
                    this.turnLeft();
                }
                if (instruction.equals(Instruction.R)) {
                    this.turnRight();
                }
                if (instruction.equals(Instruction.M)) {
                    this.moved();
                }
            });
        }
        return String.valueOf(this.pointer.getPositionX()) + " " + String.valueOf(this.pointer.getPositionY()) + " "
                + this.direction;
    }

    private void turnRight() {
        Direction result = null;
        if (this.direction == Direction.W) {
            result = Direction.S;
        }
        if (this.direction == Direction.N) {
            result = Direction.W;
        }
        if (this.direction == Direction.E) {
            result = Direction.N;
        }
        if (this.direction == Direction.S) {
            result = Direction.E;
        }
        this.setDirection(result);
    }

    private void turnLeft() {
        Direction result = null;
        if (this.direction == Direction.E) {
            result = Direction.S;
        }
        if (this.direction == Direction.N) {
            result = Direction.E;
        }
        if (this.direction == Direction.W) {
            result = Direction.N;
        }
        if (this.direction == Direction.S) {
            result = Direction.W;
        }
        this.setDirection(result);
    }

    private void moved() {
        int positionX = this.pointer.getPositionX();
        int positionY = this.pointer.getPositionY();
        if (this.direction == Direction.N) {
            positionY += 1;
        }
        if (this.direction == Direction.S) {
            positionY -= 1;
        }
        if (this.direction == Direction.E) {
            positionX += 1;
        }
        if (this.direction == Direction.W) {
            positionX -= 1;
        }
        this.setPointer(new Position(positionX, positionY));
    }
}