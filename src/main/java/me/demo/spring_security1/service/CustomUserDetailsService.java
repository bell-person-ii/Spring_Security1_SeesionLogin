package me.demo.spring_security1.service;

import lombok.RequiredArgsConstructor;
import me.demo.spring_security1.domain.User;
import me.demo.spring_security1.dto.CustomUserDetails;
import me.demo.spring_security1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // username[사용자가 로그인을 시도할때 시큐리티 컨피그가 검증을 위해 넣어준 유저네임]을 기준으로 DB에서 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("유저 조회 실패"));
        return new CustomUserDetails(user);
    }
}
