package com.example.case_md4.service;

import com.example.case_md4.model.UserDetail;
import com.example.case_md4.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<UserDetail> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Optional<UserDetail> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(UserDetail category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
