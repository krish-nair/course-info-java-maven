package com.pluralsight.courseinfo.cli.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PluralsightCourseTest {
    PluralsightCourse pluralsightCourse;
    @Test
    void durationInMinutes() {
        pluralsightCourse = new PluralsightCourse("id", "ti", "00:05:26", "http://demo", false);
        assertEquals(5, pluralsightCourse.durationInMinutes());
    }
    
    @Test
    void durationInMinutesOverHour() {
        pluralsightCourse = new PluralsightCourse("id", "ti", "03:05:26", "http://demo", false);
        assertEquals(185, pluralsightCourse.durationInMinutes());
    }

    @Test
    void durationInMinutesZero() {
        pluralsightCourse = new PluralsightCourse("id", "ti", "00:00:00", "http://demo", false);
        assertEquals(0, pluralsightCourse.durationInMinutes());
    }
}