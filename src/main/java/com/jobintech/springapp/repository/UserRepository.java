package com.jobintech.springapp.repository;

import com.jobintech.springapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
