package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.dto.MemberDto;

public interface MemberService {
    boolean register(MemberDto dto);

    /**
     *
     * @param uuid
     * uuid key로 계정 활성화
     *
     */
    boolean email(String uuid);
}
