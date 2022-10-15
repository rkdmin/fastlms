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
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    long categoryId;

    private String imagePath;
    private String keyword;
    private String subject;

    @Column(length = 1000)
    private String summary;

    @Lob// 텍스트를 많이 잡기 위함
    private String contents;
    private long price;
    private long salePrice;
    private LocalDate saleEndDt;

    private LocalDateTime regDt;// 등록일
    private LocalDateTime udtDt;// 수정일
}
