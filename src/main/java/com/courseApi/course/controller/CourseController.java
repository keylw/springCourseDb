package com.courseApi.course.controller;


import com.courseApi.course.model.Author;
import com.courseApi.course.model.Course;
import com.courseApi.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/authors/")
    public List<Author> getAuthors(){
        List<Author> a = new ArrayList<Author>();
        a.add(new Author(1, "a"));
        a.add(new Author(2, "b"));
        a.add(new Author(3, "c"));
        return a;
    }

}
