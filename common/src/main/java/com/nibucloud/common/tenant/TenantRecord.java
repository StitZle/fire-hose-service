package com.nibucloud.common.tenant;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record TenantRecord(

        @NotEmpty(message = "The field must not be empty!")
        String displayName,

        @NotEmpty(message = "The field must not be empty!")
        String dbName,

        @NotEmpty(message = "The field must not be empty!")
        String host,

        @NotNull(message = "The field must not be null and a valid integer!")
        int port,

        @NotEmpty(message = "The field must not be empty!")
        String username,

        @NotEmpty(message = "The field must not be empty!")
        String password,

        @NotNull(message = "The field must be either true or false!")
        boolean enabled,

        List<String> allowedUsers
) { }
