package com.test.transaction.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hmj
 * @date 2019/6/20
 */
@Service
public class D32MService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser3() {
        try {
            jdbcTemplate.update("UPDATE user_info SET userName='好样子' WHERE id=2");
            throw new RuntimeException("oo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
