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
        assertEquals(Navigator.N, MarsRover.parseDirection("1 2 N"));
        assertEquals(Navigator.S, MarsRover.parseDirection("1 2 S"));
        assertEquals(Navigator.W, MarsRover.parseDirection("1 2 W"));
        assertEquals(Navigator.E, MarsRover.parseDirection("1 2 E"));
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

    @Test
    public void should_report_position_when_given_turn_left() {
        assertEquals("0 0 E", MarsRover.execute("0 0 N L"));
        assertEquals("0 0 S", MarsRover.execute("0 0 N LL"));
        assertEquals("0 0 W", MarsRover.execute("0 0 N LLL"));
        assertEquals("0 0 N", MarsRover.execute("0 0 N LLLL"));
    }

    @Test
    public void should_report_position_when_given_turn_right() {
        assertEquals("0 0 W", MarsRover.execute("0 0 N R"));
        assertEquals("0 0 S", MarsRover.execute("0 0 N RR"));
        assertEquals("0 0 E", MarsRover.execute("0 0 N RRR"));
        assertEquals("0 0 N", MarsRover.execute("0 0 N RRRR"));
    }

    @Test
    public void should_report_correct_position_when_given_turn_and_move_instructions() {
        assertEquals("0 3 E", MarsRover.execute("0 0 N MMMRRR"));
        assertEquals("0 1 W", MarsRover.execute("0 0 N MR"));
        assertEquals("-1 1 S", MarsRover.execute("0 0 N MRMR"));
        assertEquals("-1 0 E", MarsRover.execute("0 0 N MRMRMR"));
    }

    @Test
    public void should_handle_back_instruction_when_given_back_instructions() {
        assertEquals("0 -1 N", MarsRover.execute("0 0 N BM"));
        assertEquals("0 0 N", MarsRover.execute("0 0 N BMBM"));
        assertEquals("0 2 N", MarsRover.execute("0 0 N BMBMMM"));
    }

}