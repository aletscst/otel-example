package com.ammfec.dto.response;

import com.ammfec.dto.general.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class UsersResponse extends BasicResponse {
    private List<User> users;
}
