package br.com.EmployeesRegistration.domain.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationData(

        @NotBlank
        String name ,
        @NotBlank
        @Email
        String login ,
        @NotBlank
        String password ,
        @NotBlank
        String telephone ,
        @NotBlank
        String gender) {
}









