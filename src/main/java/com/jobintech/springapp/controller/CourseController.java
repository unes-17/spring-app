package com.jobintech.springapp.controller;


import com.jobintech.springapp.entities.Course;
import com.jobintech.springapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(path = "all")
    public List<Course> getAllSteps() {
        return courseService.getAllCourses();
    }

    @PostMapping(path = "add")
    public void addCourse(@RequestBody Course course) {
        courseService.create(course);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStep(@PathVariable("id") long id,
                           @RequestBody Course course) {
        Course currentCourse = courseService.getCourseById(id);
        currentCourse.setTitle(course.getTitle());
        currentCourse.setDescription(course.getDescription());
        currentCourse.setInstructor(course.getInstructor());
        currentCourse.setEndDate(course.getEndDate());
        currentCourse.setStartDate(course.getStartDate());
        courseService.update(currentCourse);
    }
}
