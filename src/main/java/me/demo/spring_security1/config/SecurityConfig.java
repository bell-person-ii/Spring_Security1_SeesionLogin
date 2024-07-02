package me.demo.spring_security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 설정파일 지정
@EnableWebSecurity // 스프링 스큐리티에 등록
public class SecurityConfig {

    // 암호화 메서드
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 시큐리티 필터체인을 리턴하는 메서드를 선언함 <- 인가 설정을 지정함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth)->
                auth
                        .requestMatchers("/","/login","/loginProc","/join","/joinProc").permitAll() // 전체 접근 접근 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // admin 권한이 있는 경우에만
                        .requestMatchers("/my/**").hasAnyRole("ADMIN","USER") // admin 또는 user 권한인 경우
                        .anyRequest().authenticated() // 그외의 url 접근은 로그인된 모든 사용자에게 접근을 허용함
        );

        http.formLogin((auth)->auth.loginPage("/login").loginProcessingUrl("/loginProc").permitAll()); // 로그인을 하지 않은 상태에서 로그인이 필요한 페이지에 접근을 시도할 경우 로그인페이지로 리다이렉션 + 로그인데이터를 넘길 URL 설정


        http
                .sessionManagement((auth)-> auth
                        .maximumSessions(1) // 다중로그인 허용개수
                        .maxSessionsPreventsLogin(true)); //초과시 새로운 로그인 치딘

        http
                .sessionManagement(((auth)-> auth //로그인시 세션에 대한 쿠키(id) 변경
                        .sessionFixation().changeSessionId()));

        http
                .logout((auth) ->auth
                        .logoutSuccessUrl("/")); //get 방식 로그아웃

        return http.build();
    }

}
