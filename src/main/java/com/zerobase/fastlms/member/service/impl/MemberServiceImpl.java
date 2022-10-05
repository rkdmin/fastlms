package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.member.dto.MemberDto;
import com.zerobase.fastlms.member.entitiy.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

    @Override
    public boolean register(MemberDto dto) {
        Optional<Member> optionalMember =
                memberRepository.findById(dto.getUserId());
        if(optionalMember.isPresent()){// 이미 있음
            return false;
        }

        // 회원 가입 완료
        Member member = Member.toEntity(dto);
        memberRepository.save(member);

        // 메일 전송
        String email = dto.getUserId();
        String subject = "fastlms 가입을 축하드립니다. ";
        String text = "<p>fastlms 가입을 축하드립니다.</p>" +
                "<p>아래 링크를 클릭하셔서 가입을 완료 하세요.</p>" +
                "<div><a target='_blank' href='http://localhost:8080/member" +
                "/email?id=" +
                member.getEmailKey() + "'> 가입 완료 </a></div>";

        mailComponents.sendMail(email, subject, text);
        return true;
    }

    @Override
    public boolean email(String uuid) {
        Optional<Member> optionalMember = memberRepository.findByEmailKey(uuid);
        if(!optionalMember.isPresent()){
            return false;
        }

        Member member = optionalMember.get();
        member.setEmailYN(true);
        member.setEmailDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
