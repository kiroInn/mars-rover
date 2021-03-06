package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {
    public boolean isGood() {
        return true;
    }

    public static String execute(String command) {
        Position pointer = parsePosition(command);
        Direction direction = parseDirection(command);
        Rover rover = new Rover(pointer, direction);
        return rover.execute(parseInstructions(command));
    }

    private static List<Instruction> parseInstructions(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if (parts.length < 4) {
            return null;
        }
        List<Instruction> result = new ArrayList<Instruction>();
        String[] instructions = parts[3].split("");
        for (String instruction : instructions) {
            result.add(Instruction.valueOf(instruction));
        }
        return result;
    }

    public static Position parsePosition(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if (parts.length < 2) {
            return null;
        }
        int positionX = Integer.parseInt(parts[0]);
        int positionY = Integer.parseInt(parts[1]);
        return new Position(positionX, positionY);
    }

    public static Direction parseDirection(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if (parts.length < 3) {
            return null;
        }
        return Direction.valueOf(parts[2]);
    }
}
