package com.example.case_md4.repository;

import com.example.case_md4.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<UserDetail, Long> {
}
