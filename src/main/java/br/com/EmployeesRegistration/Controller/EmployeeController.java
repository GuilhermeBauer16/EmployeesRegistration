package br.com.EmployeesRegistration.Controller;

import br.com.EmployeesRegistration.domain.Employee.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid EmployeeRegistrationData data , UriComponentsBuilder uriBuilder){
        var employee = new Employee(data);
        repository.save(employee);
        var uri = uriBuilder.path("employee/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDetailData(employee));
    }

    @GetMapping
    public ResponseEntity< Page<EmployeesDataList>> listing(@PageableDefault(size = 10 ,sort = {"name"})Pageable page){
        var pageable =  repository.findALlByactiveTrue(page).map(EmployeesDataList::new);
        return ResponseEntity.ok(pageable);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDataEmployee updateEmployee){

        var employee = repository.getReferenceById(updateEmployee.id());
        employee.updateInformationEmployee(updateEmployee);
        return ResponseEntity.ok(new EmployeeDetailData(employee) );

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var employee = repository.getReferenceById(id);
        employee.delete();
        return  ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public  ResponseEntity employeeDetailing(@PathVariable Long id){
        var employee = repository.getReferenceById(id);
        return ResponseEntity.ok(new EmployeeDetailData(employee));
    }

}
