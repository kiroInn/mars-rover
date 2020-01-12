package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarsRoverTest {

    @Test
    public void should_report_position_and_orientation_when_given_init_position_and_orientation() {
        String expected = "0 0 N";
        String actual = MarsRover.execute("0 0 N");
        assertEquals(expected, actual);
    }

    @Test
    public void should_report_position_move_when_given_move_command() {
        String expected = "0 1 N";
        String actual = MarsRover.execute("0 0 N M");
        assertEquals(expected, actual);
    }
}