package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.entity.LoginHistory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginHistoryService {

    void add(HttpServletRequest request, String name);

    List<LoginHistory> detailList(String userId);
}
