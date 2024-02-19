package com.jobintech.springapp.service.impl;

import com.jobintech.springapp.entities.Course;
import com.jobintech.springapp.repository.CourseRepository;
import com.jobintech.springapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
