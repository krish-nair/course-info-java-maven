package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.CourseStorageService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import com.pluralsight.courseinfo.domain.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String... args) {
        LOG.info("com.pluralsight.courseinfo.domain.Course retriever starting...");
        if (args.length == 0){
            LOG.warn("Please provide author name as first argument.");
            return;
        }
        try {
            retrieveCourses(args[0]);

            // Java record benefits demo
//            PluralsightCourse course = new PluralsightCourse("id", "title", "04:30", "http://", false );
//            LOG.info("com.pluralsight.courseinfo.domain.Course details are as: {}", course);
        }catch (Exception e){
            LOG.error(  "Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();
        CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
        CourseStorageService courseStorageService = new CourseStorageService(courseRepository);

        List<PluralsightCourse> coursesToStore = courseRetrievalService.getCoursesFor(authorId)
                .stream()
//                .filter(course -> !course.isRetired()) //One way to filter
                .filter(not(PluralsightCourse::isRetired))  //Other way to filter
                .toList();
        LOG.info("Retrieved the following {} courses: , {}", coursesToStore.size(), coursesToStore);
        courseStorageService.storePluralsightCourses(coursesToStore);
        LOG.info("Courses successfully stored into the database.");
    }
}
