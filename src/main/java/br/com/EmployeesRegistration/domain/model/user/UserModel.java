package br.com.EmployeesRegistration.domain.model.user;

import br.com.EmployeesRegistration.domain.model.Employee.UpdateDataEmployee;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    private String telephone;

    private  String name;

    private String gender;

    public UserModel(UserRegistrationData userRegistrationData){
        this.name = userRegistrationData.name();
        this.login = userRegistrationData.login();
        this.password = userRegistrationData.password();
        this.telephone = userRegistrationData.telephone();
        this.gender = userRegistrationData.gender();
    }

    public void updateInformationUser(UpdateUserData updateUserData) {

        if (updateUserData.name() != null) {
            this.name = updateUserData.name();
        }
        if (updateUserData.telephone() != null) {
            this.telephone = updateUserData.telephone();

        }

        if (updateUserData.gender() != null) {
            this.gender = updateUserData.gender();

        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

