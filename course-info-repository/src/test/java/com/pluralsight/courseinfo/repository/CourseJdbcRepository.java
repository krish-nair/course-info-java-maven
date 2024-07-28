package com.pluralsight.courseinfo.repository;

import com.pluralsight.courseinfo.domain.Course;

import javax.sql.DataSource;
import java.util.List;

public class CourseJdbcRepository implements CourseRepository{
    private DataSource dataSource;

    @Override
    public void saveCourse(Course course) {

    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }
}
