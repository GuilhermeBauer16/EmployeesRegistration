package br.com.EmployeesRegistration.domain.model.Employee;

import br.com.EmployeesRegistration.domain.Address.AddressRegistrationData;
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
