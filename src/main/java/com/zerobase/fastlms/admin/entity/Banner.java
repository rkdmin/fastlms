package com.zerobase.fastlms.admin.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerName;

    int sortValue;

    String imagePath;
    String filename;
    String urlFilename;

    boolean isNewTap;
    boolean openYn;

    LocalDateTime regDt;
    LocalDateTime udtDt;

}
