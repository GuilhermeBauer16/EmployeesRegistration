package br.com.EmployeesRegistration.Employee;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {


    Page<Employee> findALlByactiveTrue(Pageable page);
}
