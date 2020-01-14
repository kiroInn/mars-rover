package com.thoughtworks;

public class MarsRover {
    public static String execute(String command) {
        Pointer pointer = parsePosition(command);
        Rover rover = new Rover(pointer);
        return rover.execute(command);
    }

	public static Pointer parsePosition(String positionCommand) {
        String[] parts = positionCommand.split(" ");
        if(parts.length < 2){
            return null;
        }
        int positionX = Integer.parseInt(parts[0]);
        int positionY = Integer.parseInt(parts[1]);
        return new Pointer(positionX, positionY);
	}
}
