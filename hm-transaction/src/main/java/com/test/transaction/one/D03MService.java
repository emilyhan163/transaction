package com.test.transaction.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hmj
 * @date 2019/6/20
 */
@Service
public class D03MService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Transactional(propagation = Propagation.REQUIRES_NEW) 可以试下这个
     *
     * addUser3里自己trycatch里，异常不会向上传播了。
     * 因为addUser3整个包裹起来，则这个业务方法也就等于脱离了spring事务的管理，因为没有任何异常会从业务方法中抛出！全被捕获并吞掉，导致spring异常抛出触发事务回滚策略失效。
     */
    @Transactional
    public void addUser3() {
        try {
            jdbcTemplate.update("UPDATE user_info SET userName='好样子' WHERE id=2;");
                throw new RuntimeException("oo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
