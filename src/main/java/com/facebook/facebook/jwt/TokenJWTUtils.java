package com.facebook.facebook.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenJWTUtils {
  static final long EXPIRATION_TIME = 86_400_000; // 1 day
  static final String SECRET = "demo";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";

  public static String generateJwt(String userId) {
    long expirationTime = EXPIRATION_TIME;
    return Jwts.builder()
        .setId(userId)
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(SignatureAlgorithm.HS512, SECRET)
        .compact();
  }

  public static String generateJwtByTime(String id,String emailOrPhone,String type,Long time,String code) {
    long expirationTime = time;
    return Jwts.builder()
            .setId(id)
            .setSubject(emailOrPhone)
            .setIssuer(type)
            .setAudience(code)
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact();
  }

  public static String parseTokenJWT(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(SECRET)
        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
        .getBody();
    return claims.getId();
  }
  public static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      // parse the token
      String userId = parseTokenJWT(token);
      return userId != null ?
          new UsernamePasswordAuthenticationToken(userId, null,null) :
          null;
    }
    return null;
  }
}
