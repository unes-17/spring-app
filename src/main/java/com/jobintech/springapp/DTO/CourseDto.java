package com.jobintech.springapp.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String category;
    private Date startDate;
    private Date endDate;

}
