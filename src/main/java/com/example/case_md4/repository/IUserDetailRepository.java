package com.example.case_md4.repository;

import com.example.case_md4.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDetailRepository extends JpaRepository<UserDetail, Long> {
}
