package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.dto.MemberDto;
import com.zerobase.fastlms.member.dto.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    boolean register(MemberDto dto);

    /**
     *
     * @param uuid
     * uuid key로 계정 활성화
     *
     */
    boolean email(String uuid);

    /**
     * 입력한 이메일로 비밀번호 초기화 정보를 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);

    /**
     * 입력받은 uuid에 대해서 password 초기화
     */
    boolean resetPassword(String id, String password);

    /**
     * 입력받은 uuid값이 유효한지 확인
     */
    boolean checkResetPassword(String uuid);
}
