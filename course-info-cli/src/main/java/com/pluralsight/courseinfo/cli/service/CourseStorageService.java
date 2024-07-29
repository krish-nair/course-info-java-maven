package com.pluralsight.courseinfo.cli.service;

import com.pluralsight.courseinfo.domain.Course;
import com.pluralsight.courseinfo.domain.repository.CourseRepository;

import java.util.List;

public class CourseStorageService {
    private final CourseRepository courseRepository;
    private final String PS_BASE_URL = "https://app.pluralsight.com";

    public CourseStorageService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses){
        for (PluralsightCourse psCourse: psCourses){
            Course course = new Course(psCourse.id(),
                    psCourse.title(), psCourse.durationInMinutes(), PS_BASE_URL + psCourse.contentUrl());
            courseRepository.saveCourse(course);
        }
    }
}
