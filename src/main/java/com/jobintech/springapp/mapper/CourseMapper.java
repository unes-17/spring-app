package com.jobintech.springapp.mapper;

import com.jobintech.springapp.DTO.CourseDto;
import com.jobintech.springapp.DTO.UserDto;
import com.jobintech.springapp.Model.Course;
import com.jobintech.springapp.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
  @Autowired
  ModelMapper modelMapper;
  public CourseDto courseToCourseDto(Course course){return modelMapper.map(course,CourseDto.class);}

  public Course courseDtoToCourse(CourseDto courseDto)  {return modelMapper.map(courseDto,Course.class);}

    public void updateCourseFromDto(CourseDto courseDto,Course course){
      course.setTitle(courseDto.getTitle());
      course.setDuration(courseDto.getDuration());
      course.setCategory(courseDto.getCategory());


  }
}

