package com.tech.subash.custom.annotion;


import lombok.Data;

@Data
public class UserDto {

    @NotBlankForGroup(
        message = "Username is required for create",
        groups = ValidationGroups.Create.class,
        payload = Severity.Error.class
    )
    private String username;

    @NotBlankForGroup(
        message = "Display name is required for update",
        groups = ValidationGroups.Update.class,
        payload = Severity.Info.class
    )
    private String displayName;

    // Getters & setters
}
