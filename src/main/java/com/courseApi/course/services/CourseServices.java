package com.courseApi.course.services;

import org.springframework.stereotype.Service;

@Service
public class CourseServices {

    public String createSlugFromTitle(String title){
        String slug = title.replaceAll("/[^a-z0-9_]+/gi", "-");
        slug = slug.replaceAll("/^-|-$/g", "");
        slug = slug.toLowerCase();
        return slug;
    }
}
