package com.ammfec.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private String address;
}
