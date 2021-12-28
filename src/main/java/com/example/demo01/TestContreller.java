package com.example.demo01;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author hanluozhen
 * @version 1.0.0
 * @ProjectName demo-01
 * @ClassName TestContreller.java
 * @Description TODO 幂等问题/防止订单重复提交
 * @createTime 2021年09月27日 08:54:00
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestContreller {

    private static HashMap tokenMaps = new HashMap(300);

    @Autowired
    Redisson redisson;

    public void dfg(){

        //获取锁
        RLock lock = redisson.getLock("test");


    }

    //获取token
    @RequestMapping("token")
    public String getToken(HttpServletRequest request){

        String token = "token"+System.currentTimeMillis();
        System.out.println("请求全路径："+request.getRequestURL());
        tokenMaps.put(token,token);
        return token;
    }

    //验证token
    public boolean checkToken(String key){
        String token = (String) tokenMaps.get(key);
        if (token == null){
            return false;
        }
        tokenMaps.remove(token);
        return true;

    }
    //请求入口
    @RequestMapping(value = "add")
    public String addOrder(HttpServletRequest request){

      String token = request.getHeader("token");
      if (token == null){
          System.out.println("=============================");
          return "令牌为空";
      }

      if (!checkToken(token)){
          return "请勿重复提交";
      }
        System.out.println("执行添加订单");
      return "订单添加成功";
    }

    public static double round(String v, int scale, int roundType) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, roundType).doubleValue();
    }

    public static void main(String[] args) {

    }

}
