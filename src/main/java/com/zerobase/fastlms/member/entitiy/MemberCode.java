package com.zerobase.fastlms.member.entitiy;

import com.zerobase.fastlms.member.model.MemberInput;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

public interface MemberCode {
    /**
     * 맴버 사용 요청중
     */
    String MEMBER_STATUS_REQ = "REQ";
    /**
     * 현재 이용중 상태
     */
    String MEMBER_STATUS_ING = "ING";
    /**
     * 현재 정지된 상태
     */
    String MEMBER_STATUS_STOP = "STOP";
}
