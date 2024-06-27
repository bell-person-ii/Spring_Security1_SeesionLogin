package me.demo.spring_security1.controller;

import lombok.RequiredArgsConstructor;
import me.demo.spring_security1.dto.JoinDTO;
import me.demo.spring_security1.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinP(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO){
        System.out.println(joinDTO.getPassword());
        joinService.joinProcess(joinDTO);
        return "redirect:/login";
    }
}
