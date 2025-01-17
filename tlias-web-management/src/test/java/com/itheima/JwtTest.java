package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "itheima");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "aGVpbWE=")
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiaXRoZWltYSIsImlkIjoxLCJleHAiOjE3MzcxMjc1Mjh9.MPzN-JY3rphWiyKmxgv5LXWMgfts_D8STnOBe6aN9CA";
        Claims claims = Jwts.parser()
                .setSigningKey("aGVpbWE=")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
