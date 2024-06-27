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
        System.out.println(password);

        return User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password)) //  패스워드 암호화
                .role("ROLE_USER")
                .build();
    }
}
