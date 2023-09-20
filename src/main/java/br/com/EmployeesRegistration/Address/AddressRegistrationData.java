package br.com.EmployeesRegistration.Address;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;

public record AddressRegistrationData(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String zipCode,
        @NotBlank
        String federaLUnit,
        @NotBlank
        String city,
        String number,
        String complement) {
}
