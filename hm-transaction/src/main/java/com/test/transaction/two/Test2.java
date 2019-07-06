package com.test.transaction.two;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hmj
 * @date 2019/6/19
 */
public class Test2 {
    public static void main(String[] args) {


        //spring-beans2.xml中，没有开启注解，所以@Transactional是不会起作用的，但是 事务的通知和切面里配置了事务的传播属性，是这个起作用
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans2.xml");

//        AService serviceA = applicationContext.getBean(AService.class);
//        serviceA.serviceMANDATORY();

        D21MService d21MService = applicationContext.getBean(D21MService.class);
        d21MService.addServiceUU();

    }
}
