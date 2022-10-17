package com.zerobase.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {

    Long id;

    String bannerName;

    int sortValue;

    String imagePath;
    String filename;
    String urlFilename;

    boolean isNewTap;
    boolean openYn;

    //삭제를 위한
    String idList;

    LocalDateTime regDt;
    String regDtText;

}
