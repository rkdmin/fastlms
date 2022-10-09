package com.zerobase.fastlms.member.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResetPasswordInput {
    private String userId;
    private String userName;

    private String id;
    private String password;
}