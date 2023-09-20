package br.com.EmployeesRegistration.Employee;


import br.com.EmployeesRegistration.Address.Address;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "employee")
@Entity(name = "Employee")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    private String gender;

    private String identification;

    @Enumerated(EnumType.STRING)

    private Post post;

    private Boolean active;

    @Embedded
    private Address address;

    public Employee(EmployeeRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.gender = data.gender();
        this.identification = data.identification();
        this.post = data.post();
        this.address = new Address(data.address());
    }
}

