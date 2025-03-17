package com.ammfec.dto.response;

import com.ammfec.dto.general.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends BasicResponse {
    private User user;
}
