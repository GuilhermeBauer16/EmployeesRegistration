package br.com.EmployeesRegistration.Address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class Address {

    private String street;
    private String neighborhood ;
    private String zipCode;
    private String number;
    private String federaLUnit;
    private String city;
    private String complement;

    public Address(AddressRegistrationData data){
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipCode = data.zipCode();
        this.number = data.number();
        this.federaLUnit = data.federaLUnit();
        this.city = data.city();
        this.complement = data.complement();
    }

}
