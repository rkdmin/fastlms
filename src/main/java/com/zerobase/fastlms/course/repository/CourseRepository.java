package com.zerobase.fastlms.course.repository;

import com.zerobase.fastlms.member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Member, String> {
    Optional<Member> findByEmailKey(String emailKey);

    Optional<Member> findByUserIdAndUserName(String userId, String userName);

    Optional<Member> findByResetPasswordKey(String resetPasswordKey);
}
