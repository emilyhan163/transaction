package com.test.transaction.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 韩美娟
 * @date 2019/6/20
 */
@Service
public class D02MService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addUser() {
        jdbcTemplate.update("update mogoroomdb.tele_calllog SET remark='好样子' where id=7968325");
        throw new RuntimeException("oo");
    }
}
