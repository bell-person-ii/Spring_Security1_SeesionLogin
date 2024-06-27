package me.demo.spring_security1.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainP(Model model){

        String id = SecurityContextHolder.getContext().getAuthentication().getName(); // 현재 세션 사용자 아이디

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 세션에서 인증객체를 가져옴

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next(); // 단일 권한이라 가정한 코드

        String role = auth.getAuthority(); // 사용자의 role 값을 가져옴

        model.addAttribute("id",id);
        model.addAttribute("role",role);
        return "main";
    }
}
