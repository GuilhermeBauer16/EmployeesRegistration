package br.com.EmployeesRegistration.domain.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {


    Page<EmployeeModel> findALlByactiveTrue(Pageable page);
}
