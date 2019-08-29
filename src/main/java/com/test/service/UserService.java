package com.test.service;

import com.test.dao.DicRepository;
import com.test.dao.UserRepository;
import com.test.pojo.Dic;
import com.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DicRepository dicRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveDic(Dic dic) {
        this.dicRepository.save(dic);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }
}
