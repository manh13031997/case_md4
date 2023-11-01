package com.example.case_md4.service.userDetail;

import com.example.case_md4.model.UserDetail;
import com.example.case_md4.repository.IUserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements IUserDetailService{
    @Autowired
    IUserDetailRepository userDetailRepository;

    @Override
    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    @Override
    public Optional<UserDetail> findById(Long id) {
        return userDetailRepository.findById(id);
    }

    @Override
    public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }

    @Override
    public void remove(Long id) {
        userDetailRepository.deleteById(id);
    }
}
