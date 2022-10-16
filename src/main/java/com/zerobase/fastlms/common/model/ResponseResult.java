package com.zerobase.fastlms.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ResponseResult {
    ResponseResultHeader header;
    Object body;

    public ResponseResult(boolean result, String message){
        header = new ResponseResultHeader(result, message);
    }

    public ResponseResult(boolean result){
        header = new ResponseResultHeader(result);
    }
}
