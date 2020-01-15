package com.thoughtworks;

public enum Navigator {
    N, S, E, W;

    public static Navigator turnRight(Navigator current) {
        switch (current) {
        case W:
            return S;
        case N:
            return W;
        case E:
            return N;
        case S:
            return E;
        default:
            return null;
        }
    }

    public static Navigator turnLeft(Navigator current) {
        switch (current) {
        case E:
            return S;
        case N:
            return E;
        case W:
            return N;
        case S:
            return W;
        default:
            return null;
        }
    }
}
