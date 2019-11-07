package com.courseApi.course.controller;


import com.courseApi.course.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

@GetMapping("/courses")
    public Course getCourses(){
        return new Course(2,"3","wsf",4,"sd");
}

}
