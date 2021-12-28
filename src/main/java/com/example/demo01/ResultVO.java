package com.example.demo01;

import lombok.Data;

/**
 * @author hanluozhen
 * @version 1.0.0
 * @ProjectName demo-01
 * @ClassName ResultVO.java
 * @Description TODO
 * @createTime 2021年09月30日 14:32:00
 */
@Data
public class ResultVO<T> {
    /**
     * 响应状态码
     */
    private String status;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应具体内容
     */
    private T data;

    public ResultVO() {

    }

    public ResultVO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultVO(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


}
