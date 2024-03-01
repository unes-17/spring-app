package com.jobintech.springapp.Service.Imp;

import com.jobintech.springapp.Model.Step;
import com.jobintech.springapp.Repository.StepRepository;
import com.jobintech.springapp.Service.StepService;
import com.jobintech.springapp.exceptions.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class StepServiceImpl implements StepService {
    @Autowired
    StepRepository stepRepository;
    @Override
    public Step create(Step step) {
        return stepRepository.save(step);
    }

    @Override
    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

    @Override
    public Step update(Long id, Step stepNew) {
        Step step =stepRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Step not found with id : " + id));
        step.setTitle(stepNew.getTitle());
        step.setDescription(stepNew.getDescription());

        return stepRepository.save(step);
    }

    @Override
    public void delete(Long id) {
        stepRepository.deleteById(id);


    }
}
