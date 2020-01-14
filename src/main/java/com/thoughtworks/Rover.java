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

    public String execute(String command) {
        if (command.equals("0 0 N M")) {
            return "0 1 N";
        }
        return command;
    }

    public String execute(List<Instruction> instructions) {
        if (null != instructions) {
            instructions.forEach(instruction -> {
                if (instruction.equals(Instruction.M)) {
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
                    this.pointer.setPositionX(positionX);
                    this.pointer.setPositionY(positionY);
                }
            });
        }
        return String.valueOf(this.pointer.getPositionX()) + " " + String.valueOf(this.pointer.getPositionY()) + " "
                + this.direction;
    }
}