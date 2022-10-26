package com.halfacode.userservice.dto;

import com.halfacode.userservice.entity.User;
import lombok.Data;

@Data
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
