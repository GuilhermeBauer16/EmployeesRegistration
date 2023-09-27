package br.com.EmployeesRegistration.Controller;


import br.com.EmployeesRegistration.domain.user.AuthenticationData;
import br.com.EmployeesRegistration.domain.user.User;
import br.com.EmployeesRegistration.infra.security.TokenJWTData;
import br.com.EmployeesRegistration.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager ;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity logIn(@RequestBody @Valid AuthenticationData authenticationData){
        var authenticationToken = new UsernamePasswordAuthenticationToken(authenticationData.login() , authenticationData.password());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTData(tokenJWT));

    }

    }

