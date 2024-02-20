package com.jobintech.springapp.Service;

import com.jobintech.springapp.Model.Course;
import com.jobintech.springapp.Model.Step;

import java.util.List;
import java.util.Optional;

public interface StepService {

    Step create(Step step);
    List<Step> getAllSteps();
    Step update(Long id, Step step);
    void delete(Long id);
}
