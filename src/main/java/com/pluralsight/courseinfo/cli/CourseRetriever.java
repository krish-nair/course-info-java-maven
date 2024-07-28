package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String... args) {
        LOG.info("Course retriever starting...");
        if (args.length == 0){
            LOG.warn("Please provide author name as first argument.");
            return;
        }
        try {
            retrieveCourses(args[0]);
        }catch (Exception e){
            LOG.error(  "Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();

        String coursesToStore = courseRetrievalService.getCoursesFor(authorId);
        LOG.info("Retrieved the following courses: {}", coursesToStore);
    }
}
