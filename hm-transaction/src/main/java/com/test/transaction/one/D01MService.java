package com.test.transaction.one;

import com.test.transaction.in.AService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 韩美娟
 * @date 2019/6/20
 */
@Service
public class D01MService {

    private static final Logger log = LoggerFactory.getLogger(AService.class);

    @Autowired
    private D02MService d02MService;

    @Autowired
    private D03MService d03MService;

    @Transactional
    public void addServiceUU() {
        log.info("d02MService........");
        //TODO <property name="globalRollbackOnParticipationFailure" value="false" />
        // 这个配置在的话，下面的try catch捕获异常了，addServiceMANDATORY才不会回滚
        //没有这个配置的话，异常捕获了但是还是会回滚 “Transaction rolled back because it has been marked as rollback-only”
        try {
            d02MService.addUser();
        } catch (Exception e) {
            System.out.println(e);
        }

        //d03MService.addUser3();
        //上面globalRollbackOnParticipationFailure的配置如果没有加，直接调用d03MService.addUser3()且方法里面自己try catch了，则addServiceMANDATORY也是不会回滚。
        // 因为addUser3整个包裹起来，则这个业务方法也就等于脱离了spring事务的管理，因为没有任何异常会从业务方法中抛出！全被捕获并吞掉，导致spring异常抛出触发事务回滚策略失效。
    }


    @Transactional
    public void addServiceUU2() {
        log.info("d03MService........");
        //TODO <property name="globalRollbackOnParticipationFailure" value="false" />
        // 这个配置在的话，下面的try catch捕获异常了，addServiceMANDATORY才不会回滚
        //没有这个配置的话，异常捕获了但是还是会回滚 “Transaction rolled back because it has been marked as rollback-only”
//        try {
//            d02MService.addUser();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        d03MService.addUser3();
        //上面globalRollbackOnParticipationFailure的配置如果没有加，直接调用d03MService.addUser3()且方法里面自己try catch了，则addServiceMANDATORY也是不会回滚。
        // 因为addUser3整个包裹起来，则这个业务方法也就等于脱离了spring事务的管理，因为没有任何异常会从业务方法中抛出！全被捕获并吞掉，导致spring异常抛出触发事务回滚策略失效。
    }
}
