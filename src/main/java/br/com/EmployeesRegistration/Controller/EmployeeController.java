package br.com.EmployeesRegistration.Controller;

import br.com.EmployeesRegistration.Employee.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<EmployeesDataList> listing(@PageableDefault(size = 10 ,sort = {"name"})Pageable page){
        return repository.findALlByactiveTrue(page).map(EmployeesDataList::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDataEmployee updateEmployee){

        var employee = repository.getReferenceById(updateEmployee.id());
        employee.updateInformationEmployee(updateEmployee);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var employee = repository.getReferenceById(id);
        employee.delete();

    }

}
