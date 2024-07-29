package com.pluralsight.courseinfo.cli.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PluralsightCourseTest {
    PluralsightCourse pluralsightCourse;
    @ParameterizedTest
    @CsvSource(textBlock = """
            03:05:26, 185
            00:05:26, 5
            00:00:00, 0
            """)
    public void durationInMinutes( String input, long expected) {
        pluralsightCourse = new PluralsightCourse("id", "ti", input, "http://demo", false);
        assertEquals(expected, pluralsightCourse.durationInMinutes());
    }

//    @Test
//    void durationInMinutesOverHour() {
//        pluralsightCourse = new PluralsightCourse("id", "ti", "03:05:26", "http://demo", false);
//        assertEquals(185, pluralsightCourse.durationInMinutes());
//    }
//
//    @Test
//    void durationInMinutesZero() {
//        pluralsightCourse = new PluralsightCourse("id", "ti", "00:00:00", "http://demo", false);
//        assertEquals(0, pluralsightCourse.durationInMinutes());
//    }
}