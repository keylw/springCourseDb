package com.courseApi.course.controller;


import com.courseApi.course.model.Author;
import com.courseApi.course.model.Course;
import com.courseApi.course.repository.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @PostMapping(value = "/courses/", consumes=APPLICATION_JSON_VALUE)
    public int postCourse(HttpEntity<String> httpEntity) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Course course = mapper.readValue(Objects.requireNonNull(httpEntity.getBody()), Course.class);
        return courseRepository.postCourse(course);
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
