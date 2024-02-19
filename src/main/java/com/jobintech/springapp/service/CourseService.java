package com.jobintech.springapp.service;

import com.jobintech.springapp.entities.Course;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CourseService {

    Course create(Course course);

    Course update(Course course);

    List<Course> getAllCourses();


    Course getCourseById(long id);

    void deleteById(Long id);
}
