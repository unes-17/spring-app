package com.jobintech.springapp.Service;


import com.jobintech.springapp.Model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course create(Course course);
    Course createCourse(Course course, Long id);
    List<Course> getAllCourses();
    Course update(Long id, Course course);
    void delete(Long id);
}
