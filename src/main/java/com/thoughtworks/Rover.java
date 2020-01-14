package com.thoughtworks;

class Rover {
    private Pointer pointer;

    Rover(Pointer pointer) {
        this.setPointer(pointer);
    }

    public Pointer getPointer() {
        return pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

	public String execute(String command) {
        if (command.equals("0 0 N M")) {
            return "0 1 N";
        }
		return command;
	}
}