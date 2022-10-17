package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

    @Query("select u from LoginHistory u " +
            "where u.userId = :userId order by u.id desc")
    List<LoginHistory> detailList(String userId);
}
