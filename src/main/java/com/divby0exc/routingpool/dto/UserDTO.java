package com.divby0exc.routingpool.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
