package com.courseApi.course.controller;


import com.courseApi.course.model.Course;
import com.courseApi.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses/")
    public List<Course> getCourses(){
        return courseRepository.getCourses();
    }

    @GetMapping("/courses/{slug}")
    public Course getCoursesBySlug(@PathVariable("slug") String slug){
        return courseRepository.getCourseBySlug(slug);
    }

}
