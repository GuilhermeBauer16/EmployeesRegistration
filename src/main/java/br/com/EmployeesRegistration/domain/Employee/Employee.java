package br.com.EmployeesRegistration.domain.Employee;


import br.com.EmployeesRegistration.domain.Address.Address;
import jakarta.persistence.*;
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

    public void updateInformationEmployee(UpdateDataEmployee updateDataEmployee){

        if (updateDataEmployee.name() != null){
            this.name = updateDataEmployee.name();
        }
        if (updateDataEmployee.phone() != null){
            this.phone = updateDataEmployee.phone();

        }

        if (updateDataEmployee.gender() != null){
            this.gender = updateDataEmployee.gender();

        }
        if (updateDataEmployee.addressRegistrationData() != null){
            address.updateInformationAddress(updateDataEmployee.addressRegistrationData());

        }
    }

    public void delete() {
        this.active = false;
    }
}

