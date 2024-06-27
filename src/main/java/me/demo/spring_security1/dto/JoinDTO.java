package me.demo.spring_security1.dto;

import lombok.*;
import me.demo.spring_security1.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class JoinDTO {

    private String username;
    private String password;

    public User toUserEntity(){

        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password)) //  패스워드 암호화
                .role("ROLE_ADMIN") // 어드민 권한을 주는 방식으로 테스트
                .build();
    }
}
