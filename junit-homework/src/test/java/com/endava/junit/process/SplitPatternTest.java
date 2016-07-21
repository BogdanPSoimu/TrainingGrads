package com.endava.junit.process;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SplitPatternTest {
    SplitPattern splitPattern;

    @Before
    public void setUp() {
        splitPattern = new SplitPattern();
    }

    @Test
    public void splitByLengthTest() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("acbd");
        stringList.add("acbded123");
        stringList.add("acbded1234568910");

        List<String> result = new ArrayList<String>();
        result.add("small");
        result.add("medium");
        result.add("long");

        assertEquals(result, splitPattern.splitByLength(stringList));
    }

    @Test
    public void getStringLengthTest () {
        String string = null;

        assertNull(splitPattern.getStringLength(string));
    }
}
