package com.ammfec.dto.general;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String type;
    private String address;
}
