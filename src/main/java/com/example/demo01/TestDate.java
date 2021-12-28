package com.example.demo01;

import java.util.Date;

/**
 * @author hanluozhen
 * @version 1.0.0
 * @ProjectName demo-01
 * @ClassName TestDate.java
 * @Description TODO
 * @createTime 2021年10月11日 14:53:00
 */
public class TestDate {


    private int count = 0;

    public static void main(String[] args) {
        TestDate testDate = new TestDate();
        testDate.test1();
    }

    public void test1(){
        Date date = new Date();
        String name1 = "wangerbei";
        test2(date,name1);
        System.out.println(date+name1);
    }

    public void test2(Date dateP, String name2){
        dateP = null;
        name2 = "zhangsan";
    }

    public void test3(){
        count++;
    }

    public void  test4(){
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        int c = a+1;
    }
}
