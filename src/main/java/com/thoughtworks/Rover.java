package com.thoughtworks;

import java.util.List;

class Rover {
    private Position position;
    private Navigator navigator;

    Rover(Position pointer, Navigator navigator) {
        this.setPointer(pointer);
        this.setNavigator(navigator);
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Position getPointer() {
        return position;
    }

    public void setPointer(Position pointer) {
        this.position = pointer;
    }

    public String execute(List<Instruction> instructions) {
        if (null != instructions) {
            instructions.forEach(instruction -> {
                if (Instruction.isLeft(instruction)) {
                    this.turnLeft();
                }
                if (Instruction.isRight(instruction)) {
                    this.turnRight();
                }
                if (Instruction.isMove(instruction)) {
                    this.move();
                }
            });
        }
        return String.valueOf(this.position.getPositionX()) + " " + String.valueOf(this.position.getPositionY()) + " "
                + this.navigator;
    }

    private void turnRight() {
        this.setNavigator(Navigator.turnRight(this.navigator));
    }

    private void turnLeft() {
        this.setNavigator(Navigator.turnLeft(this.navigator));
    }

    private void move() {
        int positionX = this.position.getPositionX();
        int positionY = this.position.getPositionY();
        if (this.navigator == Navigator.N) {
            positionY += 1;
        }
        if (this.navigator == Navigator.S) {
            positionY -= 1;
        }
        if (this.navigator == Navigator.E) {
            positionX += 1;
        }
        if (this.navigator == Navigator.W) {
            positionX -= 1;
        }
        this.setPointer(new Position(positionX, positionY));
    }
}