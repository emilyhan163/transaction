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
public class D02MService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Transactional(propagation = Propagation.REQUIRES_NEW) 可以试下这个
     * 进入addUser时新开启了一个事务，将原有事务挂起了，
     * addUser回滚了
     * 原有事务恢复了继续提交
     */
    @Transactional
    public void addUser() {
        jdbcTemplate.update("update mogoroomdb.tele_calllog SET remark='好样子' where id=7968325");
        throw new RuntimeException("oo");
    }


    /**
     @Transactional 时，
     DEBUG 2019-07-06 16:55:11.191 org.springframework.transaction.support.AbstractPlatformTransactionManager.getTransaction(372) | Creating new transaction with name [com.test.transaction.one.D01MService.addServiceUU]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
     DEBUG 2019-07-06 16:55:11.567 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(264) | Acquired Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] for JDBC transaction
     DEBUG 2019-07-06 16:55:11.571 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(281) | Switching JDBC Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] to manual commit
     INFO 2019-07-06 16:55:11.583 com.test.transaction.one.D01MService.addServiceUU(28) | d02MService........
     DEBUG 2019-07-06 16:55:11.583 org.springframework.transaction.support.AbstractPlatformTransactionManager.handleExistingTransaction(473) | Participating in existing transaction
     DEBUG 2019-07-06 16:55:11.588 org.springframework.jdbc.core.JdbcTemplate.update(502) | Executing SQL update [update mogoroomdb.tele_calllog SET remark='好样子' where id=7968325]
     DEBUG 2019-07-06 16:55:11.601 org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(845) | Participating transaction failed - marking existing transaction as rollback-only
     DEBUG 2019-07-06 16:55:11.602 org.springframework.jdbc.datasource.DataSourceTransactionManager.doSetRollbackOnly(355) | Setting JDBC transaction [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] rollback-only
     java.lang.RuntimeException: oo
     DEBUG 2019-07-06 16:55:11.603 org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(708) | Global transaction is marked as rollback-only but transactional code requested commit
     DEBUG 2019-07-06 16:55:11.603 org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(836) | Initiating transaction rollback
     DEBUG 2019-07-06 16:55:11.604 org.springframework.jdbc.datasource.DataSourceTransactionManager.doRollback(341) | Rolling back JDBC transaction on Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java]
     DEBUG 2019-07-06 16:55:11.607 org.springframework.jdbc.datasource.DataSourceTransactionManager.doCleanupAfterCompletion(384) | Releasing JDBC Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] after transaction
     Exception in thread "main" org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
     at org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(AbstractPlatformTransactionManager.java:873)
     at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:710)
     at org.springframework.transaction.interceptor.TransactionAspectSupport.commitTransactionAfterReturning(TransactionAspectSupport.java:533)
     at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:304)
     at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98)
     at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
     at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)
     at com.test.transaction.one.D01MService$$EnhancerBySpringCGLIB$$3fc0c790.addServiceUU(<generated>)
     at com.test.transaction.one.Test11.main(Test11.java:22)



     @Transactional(propagation = Propagation.REQUIRES_NEW) 时：

     DEBUG 2019-07-06 16:55:29.238 org.springframework.transaction.support.AbstractPlatformTransactionManager.getTransaction(372) | Creating new transaction with name [com.test.transaction.one.D01MService.addServiceUU]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
     DEBUG 2019-07-06 16:55:29.768 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(264) | Acquired Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] for JDBC transaction
     DEBUG 2019-07-06 16:55:29.774 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(281) | Switching JDBC Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] to manual commit
     INFO 2019-07-06 16:55:29.791 com.test.transaction.one.D01MService.addServiceUU(28) | d02MService........
     DEBUG 2019-07-06 16:55:29.792 org.springframework.transaction.support.AbstractPlatformTransactionManager.handleExistingTransaction(422) | Suspending current transaction, creating new transaction with name [com.test.transaction.one.D02MService.addUser]
     DEBUG 2019-07-06 16:55:29.794 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(264) | Acquired Connection [1807648168, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] for JDBC transaction
     DEBUG 2019-07-06 16:55:29.796 org.springframework.jdbc.datasource.DataSourceTransactionManager.doBegin(281) | Switching JDBC Connection [1807648168, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] to manual commit
     DEBUG 2019-07-06 16:55:29.803 org.springframework.jdbc.core.JdbcTemplate.update(502) | Executing SQL update [update mogoroomdb.tele_calllog SET remark='好样子' where id=7968325]
     DEBUG 2019-07-06 16:55:29.818 org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(836) | Initiating transaction rollback
     DEBUG 2019-07-06 16:55:29.829 org.springframework.jdbc.datasource.DataSourceTransactionManager.doRollback(341) | Rolling back JDBC transaction on Connection [1807648168, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java]
     DEBUG 2019-07-06 16:55:29.836 org.springframework.jdbc.datasource.DataSourceTransactionManager.doCleanupAfterCompletion(384) | Releasing JDBC Connection [1807648168, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] after transaction
     DEBUG 2019-07-06 16:55:29.837 org.springframework.transaction.support.AbstractPlatformTransactionManager.cleanupAfterCompletion(1011) | Resuming suspended transaction after completion of inner transaction
     java.lang.RuntimeException: oo
     DEBUG 2019-07-06 16:55:29.839 org.springframework.transaction.support.AbstractPlatformTransactionManager.processCommit(743) | Initiating transaction commit
     DEBUG 2019-07-06 16:55:29.841 org.springframework.jdbc.datasource.DataSourceTransactionManager.doCommit(326) | Committing JDBC transaction on Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java]
     DEBUG 2019-07-06 16:55:29.844 org.springframework.jdbc.datasource.DataSourceTransactionManager.doCleanupAfterCompletion(384) | Releasing JDBC Connection [288958772, URL=jdbc:mysql://192.168.60.102:3306/mogoroomdb?useUnicode=true&characterEncoding=UTF-8, UserName=mgwsOHnOCGSAcL@192.168.41.75, MySQL Connector Java] after transaction









     */
}
