package com.thoughtworks;

import java.util.List;
import java.util.Random;

class Rover {
    private Position position;
    private Direction direction;
    private boolean isAstern;

    Rover(Position pointer, Direction navigator) {
        this.setPointer(pointer);
        this.setNavigator(navigator);
        this.isAstern = false;
    }

    public Direction getNavigator() {
        return direction;
    }

    public void setNavigator(Direction navigator) {
        this.direction = navigator;
    }

    public Position getPointer() {
        return position;
    }

    public void setPointer(Position pointer) {
        this.position = pointer;
    }

    public boolean isBreakDown() {
        return new Random().nextInt(2) == 1;
    }

    public String execute(List<Instruction> instructions) {
        if (null != instructions) {
            instructions.forEach(instruction -> {
                if (Instruction.isBack(instruction)) {
                    this.openAstern();
                }
                if (Instruction.isLeft(instruction)) {
                    this.turnLeft();
                }
                if (Instruction.isRight(instruction)) {
                    this.turnRight();
                }
                if (Instruction.isMove(instruction)) {
                    this.move(direction, this.isAstern);
                }
            });
        }
        return String.valueOf(this.position.getPositionX()) + " " + String.valueOf(this.position.getPositionY()) + " "
                + direction;
    }

    private void openAstern() {
        isAstern = !isAstern;
    }

    private void turnRight() {
        this.setNavigator(this.direction.turnRight());
    }

    private void turnLeft() {
        this.setNavigator(this.direction.turnLeft());
    }

    private void move(Direction navigator, boolean isAstern) {
        int positionX = this.position.getPositionX();
        int positionY = this.position.getPositionY();
        if (navigator == Direction.N) {
            if (isAstern) {
                positionY -= 1;
            } else {
                positionY += 1;
            }
        }
        if (navigator == Direction.S) {
            if (isAstern) {
                positionY += 1;
            } else {
                positionY -= 1;
            }
        }
        if (navigator == Direction.E) {
            if (isAstern) {
                positionX -= 1;
            } else {
                positionX += 1;
            }
        }
        if (navigator == Direction.W) {
            if (isAstern) {
                positionX += 1;
            } else {
                positionX -= 1;
            }
        }
        this.setPointer(new Position(positionX, positionY));
    }
}