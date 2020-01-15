package com.thoughtworks;

public enum Instruction {
    M, L, R;

    public static Boolean isMove(Instruction instruction) {
        return M.equals(instruction);
    }

    public static Boolean isLeft(Instruction instruction) {
        return L.equals(instruction);
    }

    public static Boolean isRight(Instruction instruction) {
        return R.equals(instruction);
    }
}
