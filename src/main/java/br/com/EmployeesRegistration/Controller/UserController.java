package br.com.EmployeesRegistration.Controller;

import br.com.EmployeesRegistration.domain.model.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity insert(@RequestBody @Valid UserRegistrationData userRegistrationData, UriComponentsBuilder uriComponentsBuilder) {
        var newUser = new UserModel(userRegistrationData);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        var uri = uriComponentsBuilder.path("/registration/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailData(newUser));

    }

    @GetMapping
    public ResponseEntity<Page<UserListData>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {

        var pageable = userRepository.findAll(page).map(UserListData::new);
//        .
        return ResponseEntity.ok(pageable);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody UpdateUserData updateUserData) {
        var user = userRepository.getReferenceById(updateUserData.id());
        user.updateInformationUser(updateUserData);
        return ResponseEntity.ok(new UserDetailData(user));
    }

}
