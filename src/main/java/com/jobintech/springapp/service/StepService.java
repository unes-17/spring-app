package com.jobintech.springapp.service;

import com.jobintech.springapp.entities.Step;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StepService {
    List<Step> getAllSteps();

    void deleteById(Long id);

    Step create(Step step);

    Step getStepById(long id);

    Step update(Step step);
}
