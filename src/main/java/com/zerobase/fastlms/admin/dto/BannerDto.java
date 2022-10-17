package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerDto {
    Long id;

    String bannerName;

    int sortValue;

    String imagePath;
    String filename;
    String urlFilename;

    boolean newTapYn;
    boolean openYn;

    LocalDateTime regDt;

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .sortValue(banner.getSortValue())
                .imagePath(banner.getImagePath())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .newTapYn(banner.isNewTapYn())
                .openYn(banner.isOpenYn())
                .build();
    }
    
    public static List<BannerDto> of (List<Banner> list) {
        if (list != null) {
            List<BannerDto> categoryList = new ArrayList<>();
            for(Banner x : list) {
                categoryList.add(of(x));
            }
            return categoryList;
        }

        return null;
    }


    
    
}
