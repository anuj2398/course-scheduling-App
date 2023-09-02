package com.example.geektrust.constantsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constants.Constants;

public class ConstantsTest {
    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",Constants.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",Constants.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",Constants.ACCEPTED);
    }

}
