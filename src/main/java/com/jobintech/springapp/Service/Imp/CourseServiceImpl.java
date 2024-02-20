package com.jobintech.springapp.Service.Imp;

import com.jobintech.springapp.Model.Course;
import com.jobintech.springapp.Model.Enum.RoleUser;
import com.jobintech.springapp.Model.User;
import com.jobintech.springapp.Repository.CourseRepository;
import com.jobintech.springapp.Repository.UserRepository;
import com.jobintech.springapp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
       public Course createCourse(Course course, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (user.getRole() != RoleUser.EXPERT) {
            throw new RuntimeException("Only experts can create courses.");
        }

        course.setExpert(user);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    @Override
    public Course update(Long id, Course courseNew) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours not found with id : " + id));
        course.setTitle(courseNew.getTitle());
        course.setDuration(courseNew.getDuration());
        course.setEndDate(courseNew.getEndDate());
        course.setDescription(courseNew.getDescription());
        course.setStartDate(courseNew.getStartDate());
        course.setCategory(courseNew.getCategory());
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);

    }
}
