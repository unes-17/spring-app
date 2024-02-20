package com.jobintech.springapp.Controller;

import com.jobintech.springapp.Model.Step;
import com.jobintech.springapp.Service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/steps")
public class StepController {
    @Autowired
    StepService stepService;
    @PostMapping("/save")
    public Step create(@RequestBody Step step) {
        return stepService.create(step);
    }
    @GetMapping("/steps")
    public List<Step> getAllSteps() {
        return stepService.getAllSteps();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            stepService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Step> update(@PathVariable Long id, @RequestBody Step step) {
        try {
            Step updatedStep = stepService.update(id, step);
            return ResponseEntity.ok(updatedStep);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
