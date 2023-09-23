package br.com.EmployeesRegistration.Employee;

import br.com.EmployeesRegistration.Address.AddressRegistrationData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDataEmployee(
        @NotNull
        Long id,
        String name ,
        String phone ,
        String gender ,
        AddressRegistrationData addressRegistrationData
) {
}
