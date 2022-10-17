package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public void add(HttpServletRequest request, String userId) {
        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);
        log.info(userAgent);
        log.info(clientIp);

        loginHistoryRepository.save(LoginHistory.builder()
                .userId(userId)
                .regDt(LocalDateTime.now())
                .clientIp(clientIp)
                .userAgent(userAgent)
                .build());
    }

    @Override
    public List<LoginHistory> detailList(String userId) {

        return loginHistoryRepository.detailList(userId);
    }
}















