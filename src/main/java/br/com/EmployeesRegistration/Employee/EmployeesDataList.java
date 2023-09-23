package br.com.EmployeesRegistration.Employee;

public record EmployeesDataList(Long id ,String name, String gender, String phone, Post post) {

    public EmployeesDataList(Employee employee) {
        this(employee.getId() ,employee.getName(), employee.getGender(), employee.getPhone(), employee.getPost());
    }
}
