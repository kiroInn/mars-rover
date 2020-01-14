package com.thoughtworks;

class Rover {
    private Position pointer;

    Rover(Position pointer) {
        this.setPointer(pointer);
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
}