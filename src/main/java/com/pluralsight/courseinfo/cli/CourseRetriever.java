package com.pluralsight.courseinfo.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String[] args) {
        System.out.println("Course retriever starting...");
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
        LOG.info("Retrieving courses for '{}' ", authorId);
    }
}
