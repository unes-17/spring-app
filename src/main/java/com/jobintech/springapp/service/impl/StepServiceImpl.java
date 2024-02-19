package com.jobintech.springapp.service.impl;

import com.jobintech.springapp.entities.Step;
import com.jobintech.springapp.repository.StepRepository;
import com.jobintech.springapp.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {


    @Autowired
    StepRepository stepRepository;

    @Override
    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        stepRepository.deleteById(id);
    }

    @Override
    public Step create(Step step) {
        return stepRepository.save(step);
    }

    @Override
    public Step getStepById(long id) {
        return stepRepository.findById(id).orElse(null);
    }

    @Override
    public Step update(Step step) {
        return stepRepository.save(step);
    }
}
