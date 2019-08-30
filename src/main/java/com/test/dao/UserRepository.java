package com.test.dao;

import com.test.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u")
    Page<User> findByPage(Pageable pageable);

    @Query(value = "select tu.*, tui.id as info_id from tb_user tu left join tb_user_info tui on tu.id = tui.user_id where tu.id = :id", nativeQuery = true)
    Map findUserAndInfoByUserId(@Param("id") Long id);
}
