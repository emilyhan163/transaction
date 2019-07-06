package com.test.transaction.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 韩美娟
 * @date 2019/6/19
 */
@Service
public class AService implements IAService {

    private static final Logger log = LoggerFactory.getLogger(AService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BService serviceB;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void serviceUU() {
        log.info("ServiceA........");
        serviceB.addUser();
    }
}
