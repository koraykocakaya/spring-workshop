package com.kk.workshop.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifierFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("AUTHORIZATION");
        if(header == null || !header.startsWith("BEARER ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        try {
            Jws<Claims> claims =  Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor("sadadhgzxcjgjhzxchjasgjdgajsgjhasgjhasgdhjasgqwtyeytasasdh1231234544vasvnsabd23sadadhgzxcjgjhzxchjasgjdgajsgjhasgjhasgdhjasgqwtyeytasasdh1231234544vasvnsabd23sadadhgzxcjgjhzxchjasgjdgajsgjhasgjhasgdhjasgqwtyeytasasdh1231234544vasvnsabd23".getBytes()))
                    .build()
                    .parseClaimsJws(token);

            Claims body = claims.getBody();
            String username = body.getSubject();
            List<Map<String, String>> auths = (List<Map<String, String>>)body.get("authorities");

            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = auths.stream()
                    .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());

            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e){
            throw new RuntimeException(String.format("Token not valid %s", token));
        }
        filterChain.doFilter(request, response);
    }
}
