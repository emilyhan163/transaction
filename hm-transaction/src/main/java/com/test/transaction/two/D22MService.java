package com.test.transaction.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author hmj
 * @date 2019/6/20
 */
@Service
public class D22MService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    @Transactional
    public void addUser() {
        jdbcTemplate.update("UPDATE user_info SET userName='好样子' WHERE id=2");
        throw new RuntimeException("oo");
    }
}
