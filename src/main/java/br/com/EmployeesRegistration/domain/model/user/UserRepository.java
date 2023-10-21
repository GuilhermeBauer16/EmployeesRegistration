package br.com.EmployeesRegistration.domain.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository  extends JpaRepository<UserModel, Long> {
    UserDetails findByLogin(String login);
}
