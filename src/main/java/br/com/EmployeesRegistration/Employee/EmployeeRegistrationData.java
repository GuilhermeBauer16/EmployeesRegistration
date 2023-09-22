package br.com.EmployeesRegistration.Employee;


import br.com.EmployeesRegistration.Address.AddressRegistrationData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmployeeRegistrationData(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,

        @NotBlank
        String gender,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String identification,

        @NotNull
        Post post,
        @NotNull
        @Valid
        AddressRegistrationData address

) {
}
