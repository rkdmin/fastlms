package com.zerobase.fastlms.member.entitiy;

import com.zerobase.fastlms.member.dto.MemberDto;
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
public class Member {
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

    public static Member toEntity(MemberDto dto){
        return Member.builder()
                .userId(dto.getUserId())
                .userName(dto.getUserName())
                .phone(dto.getPhone())
                .password(dto.getPassword())
                .regDt(LocalDateTime.now())
                .emailYN(false)
                .emailKey(UUID.randomUUID().toString())
                .build();
    }
}
