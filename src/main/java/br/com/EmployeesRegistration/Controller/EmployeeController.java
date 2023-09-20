package br.com.EmployeesRegistration.Controller;

import br.com.EmployeesRegistration.Employee.Employee;
import br.com.EmployeesRegistration.Employee.EmployeeRegistrationData;
import br.com.EmployeesRegistration.Employee.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;
    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid EmployeeRegistrationData data ){
        repository.save(new Employee(data));
    }

}
