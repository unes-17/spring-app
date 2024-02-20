package com.jobintech.springapp.Controller;

import com.jobintech.springapp.Model.Course;
import com.jobintech.springapp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/save")
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }
    @PostMapping("/save/expert")
    public Course createCourse(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PostMapping("/save/{expertId}")
    public ResponseEntity<Course> createCourse(@PathVariable Long expertId, @RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course, expertId));
    }



    @GetMapping("/courses")
    public List<Course> getAllUsers() {
        return courseService.getAllCourses();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            courseService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.update(id, course);
            return ResponseEntity.ok(updatedCourse);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
