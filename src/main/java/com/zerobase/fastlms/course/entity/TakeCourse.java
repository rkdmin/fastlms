package com.zerobase.fastlms.course.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TakeCourse implements TakeCourseCode{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    long courseId;
    String userId;

    long payPrice;// 결제 금액
    String status;// 상태(수강신청, 결제완료, 수강취소)

    private LocalDateTime regDt;// 신청일
}
