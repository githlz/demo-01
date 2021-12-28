package com.example.demo01;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author hanluozhen
 * @version 1.0.0
 * @ProjectName demo-01
 * @ClassName BuilderTest.java
 * @Description TODO
 * @createTime 2021年09月30日 15:37:00
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BuilderTest {

    private Integer age;

    private String name;

    private char sex;

    private BigDecimal price;



}
