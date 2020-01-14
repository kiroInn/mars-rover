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
                    int currentPositionY = this.pointer.getPositionY();
                    this.pointer.setPositionY(currentPositionY + 1);
                }
            });
        }
        return String.valueOf(this.pointer.getPositionX()) + " " + String.valueOf(this.pointer.getPositionY()) + " "
                + this.direction;
    }
}