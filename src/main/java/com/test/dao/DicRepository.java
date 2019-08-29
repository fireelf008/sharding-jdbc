package com.test.dao;

import com.test.pojo.Dic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DicRepository extends JpaRepository<Dic, Long> {

}
