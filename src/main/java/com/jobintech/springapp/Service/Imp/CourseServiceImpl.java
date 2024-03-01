package com.jobintech.springapp.Service.Imp;

import com.jobintech.springapp.DTO.CourseDto;
import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.Course;
import com.jobintech.springapp.Model.Enum.RoleUser;
import com.jobintech.springapp.Model.User;
import com.jobintech.springapp.Repository.CourseRepository;
import com.jobintech.springapp.Repository.UserRepository;
import com.jobintech.springapp.Service.CourseService;
import com.jobintech.springapp.exceptions.NoSuchElementFoundException;
import com.jobintech.springapp.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }



    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    @Override
    public Course update(Long id, Course courseNew) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Cours not found with id : " + id));
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

    ///// DTO


    public CourseDto createDto(CourseDto courseDto){
        Course course=courseMapper.courseDtoToCourse(courseDto);
        course=courseRepository.save(course);
        return courseMapper.courseToCourseDto(course);
    }

    @Override
    public CourseDto updateDto(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Cours  not found with id : " + id));

        courseMapper.updateCourseFromDto(courseDto, course);
        course = courseRepository.save(course);
        return courseMapper.courseToCourseDto(course);
    }




    @Override
    public List<CourseDto> getAllCoursesDto() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }


    //    @Override
//       public Course createCourse(Course course, Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementFoundException("User not found with id: " + id));
//
//        if (user.getRole() != RoleUser.EXPERT) {
//            throw new NoSuchElementFoundException("Only experts can create courses.");
//        }
//
//        course.setExpert(user);
//        return courseRepository.save(course);
//    }





    //    @Override
//    public CourseDto updateDto(Long id, CourseDto courseDto) {
//        Course course = courseRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementFoundException(
//                        getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), String.valueOf(id))
//                ));
//
//        courseMapper.updateCourseFromDto(courseDto, course);
//        course = courseRepository.save(course);
//        return courseMapper.courseToCourseDto(course);
//    }
}
