package com.test.transaction.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hmj
 * @date 2019/6/19
 */
@Service
public class BService implements IBService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void addUser() {
        jdbcTemplate.update("update mogoroomdb.tele_calllog SET remark='好样子' where id=7968325");
    }
}
