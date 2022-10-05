package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.dto.MemberDto;
import com.zerobase.fastlms.member.entitiy.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String register(){
        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, MemberDto memberDto){

        boolean result = memberService.register(memberDto);
        model.addAttribute("result", result);// v에 띄워주기위함

        return "member/register_complete";
    }

    @GetMapping("/member/email")
    public String email(Model model, HttpServletRequest request){
        String uuid = request.getParameter("id");

        boolean result = memberService.email(uuid);
        model.addAttribute("result", result);

        return "member/email";
    }
}
