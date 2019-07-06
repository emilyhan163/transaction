package com.test.transaction.three;

import com.test.transaction.in.AService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 韩美娟
 * @date 2019/6/20
 */
@Service
public class D31MService {

    private static final Logger log = LoggerFactory.getLogger(AService.class);

    @Autowired
    private D32MService d04MService;

    public void addService() {
        log.info("d04MService........");
        d04MService.createUser3();
    }
}
