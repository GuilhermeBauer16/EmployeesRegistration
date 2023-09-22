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
    private String zip_code;
    private String number;

    private String city;
    private String complement;

    public Address(AddressRegistrationData data){
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zip_code = data.zip_code();
        this.number = data.number();
        this.city = data.city();
        this.complement = data.complement();
    }

}
