package com.zerobase.fastlms.member.entitiy;

import com.zerobase.fastlms.member.model.MemberInput;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member implements MemberCode{
    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;

    private boolean emailYN;
    private String emailKey;
    private LocalDateTime emailDt;

    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;

    private boolean adminYN;

    private String userStatus;

    public static Member toEntity(MemberInput dto){
        return Member.builder()
                .userId(dto.getUserId())
                .userName(dto.getUserName())
                .phone(dto.getPhone())
                .password(dto.getPassword())
                .regDt(LocalDateTime.now())
                .emailYN(false)
                .userStatus(Member.MEMBER_STATUS_REQ)
                .emailKey(UUID.randomUUID().toString())
                .build();
    }
}
