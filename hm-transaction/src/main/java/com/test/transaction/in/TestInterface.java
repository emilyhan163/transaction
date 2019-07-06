package com.test.transaction.in;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 韩美娟
 * @date 2019/6/19
 */
public class TestInterface {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");

        AService serviceA = applicationContext.getBean(AService.class);
        serviceA.serviceUU();

//        D01MService serviceA = applicationContext.getBean(D01MService.class);
//        //serviceA.serviceMANDATORY();

    }
}
