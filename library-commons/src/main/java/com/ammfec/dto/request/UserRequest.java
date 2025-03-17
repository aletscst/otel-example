package com.ammfec.dto.request;

import com.ammfec.dto.general.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequest extends User {
    private String password;
}
