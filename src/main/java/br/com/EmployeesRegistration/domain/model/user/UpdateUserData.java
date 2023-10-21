package br.com.EmployeesRegistration.domain.model.user;

import jakarta.validation.constraints.NotNull;

public record UpdateUserData(
        @NotNull
        Long id,
        String name ,
        String telephone ,
        String gender
) {
}
