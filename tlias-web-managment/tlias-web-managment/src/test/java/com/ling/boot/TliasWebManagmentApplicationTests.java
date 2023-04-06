package com.ling.boot;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagmentApplicationTests {

    /*@Test
    public void testUuid(){
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }*/
    /*测试jwt的生成*/
    @Test
    public void testGenJwt(){

        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "niuma")//签名算法
                .setClaims(claims) //自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000)) //有效期  //设置有效期为1小时
                .compact();

        System.out.println(jwt);

    }
//    @Test
//    public  void testParseJwt(){
//        Claims claims = Jwts.parser()
//                .setSigningKey("niuma") //指定签名秘钥
//                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4MDA4NjMzNn0.RqERi00yJv0JnleS3r2YEABqeFAw-Vk9Ix4f594EDFs") //解析令牌
//                .getBody();
//        System.out.println(claims); //解析后的令牌对象
//    }

}
