package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount();

        List<BannerDto> list = bannerMapper.selectList();

        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public List<BannerDto> listFront() {

        List<BannerDto> bannerList = null;

        Optional<List<Banner>> optionalBannerList = bannerRepository.findByOpenYnOrderBySortValue(true);

        if (optionalBannerList.isPresent()) {
            List<Banner> banners = optionalBannerList.get();
            bannerList = BannerDto.of(banners);
        }

        return bannerList;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    private LocalDate getLocalDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(value, formatter);
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalCourse = bannerRepository.findById(parameter.getId());
        if (!optionalCourse.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Banner banner = optionalCourse.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setSortValue(parameter.getSortValue());
        banner.setImagePath(parameter.getImagePath());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());
        banner.setNewTapYn(parameter.isNewTapYn());
        banner.setOpenYn(parameter.isOpenYn());
        banner.setUdtDt(LocalDateTime.now());
        bannerRepository.save(banner);
        return true;
    }

    @Override
    public boolean add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .sortValue(parameter.getSortValue())
                .imagePath(parameter.getImagePath())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .openYn(parameter.isOpenYn())
                .newTapYn(parameter.isNewTapYn())
                .regDt(LocalDateTime.now())
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }
}
