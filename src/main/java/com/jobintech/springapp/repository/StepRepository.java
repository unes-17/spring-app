package com.jobintech.springapp.repository;

import com.jobintech.springapp.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
