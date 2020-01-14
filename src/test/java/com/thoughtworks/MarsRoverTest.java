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
    public void should_parse_correct_position_when_given_command() {
        assertEquals(new Position(1, 2), MarsRover.parsePosition("1 2 N M"));
    }

    @Test
    public void should_parse_correct_orientation_when_given_command() {
        assertEquals(Direction.N, MarsRover.parseDirection("1 2 N"));
        assertEquals(Direction.S, MarsRover.parseDirection("1 2 S"));
        assertEquals(Direction.W, MarsRover.parseDirection("1 2 W"));
        assertEquals(Direction.E, MarsRover.parseDirection("1 2 E"));
    }

    @Test
    public void should_report_position_move_when_given_move_command_and_north() {
        assertEquals("0 1 N", MarsRover.execute("0 0 N M"));
        assertEquals("0 2 N", MarsRover.execute("0 0 N MM"));
        assertEquals("0 3 N", MarsRover.execute("0 0 N MMM"));

        assertEquals("1 6 N", MarsRover.execute("1 5 N M"));
        assertEquals("1 7 N", MarsRover.execute("1 5 N MM"));
        assertEquals("1 8 N", MarsRover.execute("1 5 N MMM"));
    }

    @Test
    public void should_report_position_move_when_given_move_command_and_south() {
        assertEquals("0 0 S", MarsRover.execute("0 1 S M"));
        assertEquals("0 0 S", MarsRover.execute("0 1 S M"));
        assertEquals("0 0 S", MarsRover.execute("0 2 S MM"));

        assertEquals("1 2 S", MarsRover.execute("1 3 S M"));
        assertEquals("2 1 S", MarsRover.execute("2 3 S MM"));
        assertEquals("3 0 S", MarsRover.execute("3 3 S MMM"));
    }

    @Test
    public void should_report_position_move_when_given_move_command_and_west() {
        assertEquals("-1 1 W", MarsRover.execute("0 1 W M"));
        assertEquals("-2 1 W", MarsRover.execute("0 1 W MM"));
        assertEquals("-3 2 W", MarsRover.execute("0 2 W MMM"));
    }

    @Test
    public void should_report_position_move_when_given_move_command_and_east() {
        assertEquals("1 1 E", MarsRover.execute("0 1 E M"));
        assertEquals("2 1 E", MarsRover.execute("0 1 E MM"));
        assertEquals("3 2 E", MarsRover.execute("0 2 E MMM"));
    }
}