package com.courseApi.course.services;

import org.springframework.stereotype.Service;

@Service
public class CourseServices {
    public String createSlugFromTitle(String title){
        String slug = title.replaceAll("\\s+","-");
        slug = slug.toLowerCase();
        return slug;
    }
}
