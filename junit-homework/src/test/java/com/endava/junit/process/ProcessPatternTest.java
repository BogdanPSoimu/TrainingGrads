package com.endava.junit.process;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessPatternTest {
    ProcessPattern processPattern;

    @Before
    public void setUp() {
        processPattern = new ProcessPattern();
    }

    @Test
    public void testGeneratePositionNull () {
        String grade = null;
        int age = 3;
        assertNull(processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionNegative () {
        String grade = "abcd";
        int age = -1;
        assertNull(processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionJuniorDeveloper () {
        String grade = "junior";
        int age = 1;
        assertEquals("Junior Developer", processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionDeveloper1 () {
        String grade = "middle";
        int age = 1;
        assertEquals("Developer 1", processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionDeveloper2 () {
        String grade = "middle";
        int age = 3;
        assertEquals("Developer 2", processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionSenior1 () {
        String grade = "senior";
        int age = 3;
        assertEquals("Senior 1", processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionSenior2 () {
        String grade = "senior";
        int age = 7;
        assertEquals("Senior 2", processPattern.generatePosition(grade, age));
    }

    @Test
    public void testGeneratePositionUnknownPosition () {
        String grade = "senior dev";
        int age = 7;
        assertEquals("Unknown Position", processPattern.generatePosition(grade, age));
    }


}
