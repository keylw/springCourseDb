package com.courseApi.course.repository;


import com.courseApi.course.model.Course;
import com.courseApi.course.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    CourseServices courseServices;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Course> getCourses(){
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new CourseQueryMapper());
    }

    public Course getCourseBySlug(String slug){
        String sql = "SELECT * FROM courses WHERE slug = \"" + slug + "\"";
        List<Course> course = jdbcTemplate.query(sql, new CourseQueryMapper());
        return course == null? null : course.get(0) ;
    }

    public int postCourse(Course course){
        course.setSlug(courseServices.createSlugFromTitle(course.getTitle()));
        return jdbcTemplate.update(
                "INSERT INTO courses VALUES(?,?,?,?,?)",
                0,
                course.getTitle(),
                course.getSlug(),
                course.getAuthorId(),
                course.getCategory()
        );
    }

    public int updateCourse(Course course){
        course.setSlug(courseServices.createSlugFromTitle(course.getTitle()));
        return jdbcTemplate.update(
                "UPDATE courses SET title = ?, author_id = ?, category = ?, slug = ? WHERE id = ?",
                course.getTitle(),
                course.getAuthorId(),
                course.getCategory(),
                courseServices.createSlugFromTitle(course.getTitle()),
                course.getId()
        );
    }
}

class CourseQueryMapper implements RowMapper<Course> {
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Course(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("slug"),
                rs.getInt("author_id"),
                rs.getString("category")
        );
    }
}
