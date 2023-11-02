package com.example.case_md4.repository;

import com.example.case_md4.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
