package br.com.EmployeesRegistration.Controller;


import br.com.EmployeesRegistration.domain.user.User;
import br.com.EmployeesRegistration.domain.user.UserDetailData;
import br.com.EmployeesRegistration.domain.user.UserRegistrationData;
import br.com.EmployeesRegistration.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional

    public ResponseEntity userRegistration(@RequestBody @Valid UserRegistrationData userRegistrationData , UriComponentsBuilder uriBuilder){
        var user = new User(userRegistrationData);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var uri = uriBuilder.path("/registration/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailData(user));

    }
}
