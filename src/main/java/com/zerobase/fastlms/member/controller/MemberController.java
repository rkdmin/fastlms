package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.model.ResetPasswordInput;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String registerSubmit(Model model, MemberInput memberInput){

        boolean result = memberService.register(memberInput);
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

    @GetMapping("/member/info")
    public String memberInfo(){
        return "member/info";
    }

    @RequestMapping("/member/login")// 겟포트스 둘다 ok
    public String login(){
        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword(){
        return "member/find_password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(
            Model model, ResetPasswordInput parameter){

        boolean result = false;

        try{
            result = memberService.sendResetPassword(parameter);
        }catch (Exception e){
        }


        model.addAttribute("result", result);

        return "member/find_password_result";
    }


    @GetMapping("/member/reset/password")
    public String resetPassword(Model model, HttpServletRequest request){
        String uuid = request.getParameter("id");

        boolean result = memberService.checkResetPassword(uuid);

        model.addAttribute("result", result);

        return "member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter){
        boolean result = false;
        System.out.println(parameter);
        try{
            result = memberService.resetPassword(parameter.getId(),
                    parameter.getPassword());
        }catch (Exception e){
        }

        model.addAttribute("result", result);

        return "member/reset_password_result";
    }
}
