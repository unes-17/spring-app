package com.jobintech.springapp.controller;

import com.jobintech.springapp.entities.Step;
import com.jobintech.springapp.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/steps")
public class StepController {

    @Autowired
    StepService stepService;

    @GetMapping(path = "all")
    public List<Step> getAllSteps() {
        return stepService.getAllSteps();
    }

    @PostMapping(path = "add")
    public void addStep(@RequestBody Step step) {
        stepService.create(step);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStep(@PathVariable Long id) {
        stepService.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStep(@PathVariable("id") long id,
                           @RequestBody Step step) {
        Step currentStep = stepService.getStepById(id);
        currentStep.setTitle(step.getTitle());
        currentStep.setStatus(step.getStatus());
        currentStep.setUpdatedAt(new Date());
        stepService.update(currentStep);
    }
}
