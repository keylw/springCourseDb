package com.courseApi.course.repository;


import com.courseApi.course.model.Course;
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
        return jdbcTemplate.update(
                "INSERT INTO courses VALUES(?,?,?,?,?)",
                course.getId(),
                course.getTitle(),
                course.getSlug(),
                course.getAuthorId(),
                course.getCategory()
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
