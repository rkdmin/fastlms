package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entitiy.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDto {
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;

    private boolean emailYN;
    private LocalDateTime emailDt;
    private String emailKey;

    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;

    private boolean adminYN;

    private String userStatus;

    // 추가 컬럼
    private long totalCount;
    long seq;

    public static MemberDto toDto(Member member) {
        return MemberDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .phone(member.getPhone())
                .userStatus(member.getUserStatus())
                .password(member.getPassword())
                .regDt(member.getRegDt())
                .emailYN(member.isEmailYN())
                .emailDt(member.getEmailDt())
                .emailKey(member.getEmailKey())
                .resetPasswordKey(member.getResetPasswordKey())
                .resetPasswordLimitDt(member.getResetPasswordLimitDt())
                .adminYN(member.isAdminYN())
                .build();
    }
}
