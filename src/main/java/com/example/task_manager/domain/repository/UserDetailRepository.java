package com.example.task_manager.domain.repository;

import com.example.task_manager.domain.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

  boolean existsByEmail(String email);
}
