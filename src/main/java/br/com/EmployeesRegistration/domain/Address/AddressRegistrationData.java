package br.com.EmployeesRegistration.domain.Address;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;

public record AddressRegistrationData(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip_code,
        @NotBlank
        String city,
        String number,
        String complement
) {
}
