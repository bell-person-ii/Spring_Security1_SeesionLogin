package me.demo.spring_security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 설정파일 지정
@EnableWebSecurity // 스프링 스큐리티에 등록
public class SecurityConfig {

    // 시큐리티 필터체인을 리턴하는 메서드를 선언함 <- 인가 설정을 지정함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth)->
                auth
                        .requestMatchers("/","/login").permitAll() // 전체 접근 접근 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // admin 권한이 있는 경우에만
                        .requestMatchers("/my/**").hasAnyRole("ADMIN","USER") // admin 또는 user 권한인 경우
                        .anyRequest().authenticated() // 그외의 url 접근은 로그인된 모든 사용자에게 접근을 허용함
        );

        return http.build();
    }
}
