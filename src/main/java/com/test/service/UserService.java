package com.test.service;

import com.test.dao.DicRepository;
import com.test.dao.UserInfoRepository;
import com.test.dao.UserRepository;
import com.test.pojo.Dic;
import com.test.pojo.User;
import com.test.pojo.UserInfo;
import com.test.utils.SnowflakeIdUtils;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private DicRepository dicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    public void saveDic(Dic dic) {
        this.dicRepository.save(dic);
    }

    @ShardingTransactionType(TransactionType.LOCAL)
    @Transactional
    public void save(User user) {
        this.userRepository.save(user);
        UserInfo userInfo = new UserInfo();

        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(0, 0);
        userInfo.setId(snowflakeIdUtils.nextId());
        userInfo.setUserId(user.getId());
        this.userInfoRepository.save(userInfo);
    }

    public Page<User> findUserByPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return this.userRepository.findByPage(pageable);
    }

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    public Map findUserAndInfoByUserId(Long id) {
        return this.userRepository.findUserAndInfoByUserId(id);
    }
}
