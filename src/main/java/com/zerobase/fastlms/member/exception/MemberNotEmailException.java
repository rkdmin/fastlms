package com.zerobase.fastlms.member.exception;

public class MemberNotEmailException extends RuntimeException {
    public MemberNotEmailException(String error) {
        super(error);
    }
}
