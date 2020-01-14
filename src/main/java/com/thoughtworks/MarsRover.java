package com.thoughtworks;

public class MarsRover {
    public static String execute(String command) {
        Position pointer = parsePosition(command);
        Rover rover = new Rover(pointer);
        return rover.execute(command);
    }

	public static Position parsePosition(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if(parts.length < 2){
            return null;
        }
        int positionX = Integer.parseInt(parts[0]);
        int positionY = Integer.parseInt(parts[1]);
        return new Position(positionX, positionY);
	}

	public static Direction parseDirection(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if(parts.length < 3){
            return null;
        }
		return Direction.valueOf(parts[2]);
	}
}
