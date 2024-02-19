package com.jobintech.springapp.repository;

import com.jobintech.springapp.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
