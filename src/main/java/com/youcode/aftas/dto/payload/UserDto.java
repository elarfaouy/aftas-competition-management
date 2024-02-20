package com.youcode.aftas.dto.payload;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class UserDto implements Serializable {
    private String username;
    private String password;
    private String role;
    private List<String> permissions;
}
