package com.thoughtworks;

public class MarsRover {
    public static String execute(String command) {
        Rover rover = new Rover(0, 0);
        return rover.execute(command);
    }
}
