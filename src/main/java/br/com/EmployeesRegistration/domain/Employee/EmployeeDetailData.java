package br.com.EmployeesRegistration.domain.Employee;

import br.com.EmployeesRegistration.domain.Address.Address;

public record EmployeeDetailData(Long id, String name, String email, String phone, String gender,
                                 String identification, Post post, Address address) {

    public EmployeeDetailData(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.getPhone(), employee.getGender(),
                employee.getIdentification(), employee.getPost(), employee.getAddress());
    }
}
