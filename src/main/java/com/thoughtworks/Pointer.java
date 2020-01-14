package com.thoughtworks;

public class Pointer {
    private int positionX;
    private int positionY;

    Pointer(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object obj) {
        Pointer pointer = (Pointer) obj;
        return this.positionX == pointer.getPositionX() &&
        this.positionY == pointer.getPositionY();
    }
}
