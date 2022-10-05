package com.zerobase.fastlms.member.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDto {
    private String userId;
    private String userName;
    private String password;
    private String phone;
}
