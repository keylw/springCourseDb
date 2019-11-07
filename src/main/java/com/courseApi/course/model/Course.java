package com.courseApi.course.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Course {
    private int id;
    private String title;
    private String slug;
    private int authorId;
    private String category;

    public Course(int id, String title, String slug, int authorId, String category) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.authorId = authorId;
        this.category = category;
    }
}
