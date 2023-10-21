package br.com.EmployeesRegistration.domain.model.Employee;

public record EmployeesDataList(Long id ,String name, String gender, String phone, Post post) {

    public EmployeesDataList(EmployeeModel employee) {
        this(employee.getId() ,employee.getName(), employee.getGender(), employee.getPhone(), employee.getPost());
    }
}
