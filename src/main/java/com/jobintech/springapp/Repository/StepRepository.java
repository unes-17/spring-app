package com.jobintech.springapp.Repository;

import com.jobintech.springapp.Model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step,Long> {
}
