package com.docme.docmeapi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    @NotEmpty(message = "first name is required")
    private String firstName;
    @NotEmpty(message = "last name is required")
    private String lastName;
    private String middleName;
    @NotEmpty(message = "email is required")
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;


}
