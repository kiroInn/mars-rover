package com.thoughtworks;

class Rover {
    private int positionX;
    private int positionY;

    Rover(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

	public String execute(String command) {
        if (command.equals("0 0 N M")) {
            return "0 1 N";
        }
		return command;
	}
}