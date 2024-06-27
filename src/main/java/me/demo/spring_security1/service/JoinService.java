package me.demo.spring_security1.service;

import lombok.RequiredArgsConstructor;
import me.demo.spring_security1.domain.User;
import me.demo.spring_security1.dto.JoinDTO;
import me.demo.spring_security1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    public void joinProcess(JoinDTO joinDTO){
        if(userRepository.existsByUsername(joinDTO.getUsername())){
            throw new RuntimeException("이미 가입된 회원입니다.");
        }
        User user = joinDTO.toUserEntity();
        userRepository.save(user);
    }
}
