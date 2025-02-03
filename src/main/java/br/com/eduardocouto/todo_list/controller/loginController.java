package br.com.eduardocouto.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardocouto.todo_list.entity.user.LoginResponseDTO;
import br.com.eduardocouto.todo_list.entity.user.Users;
import br.com.eduardocouto.todo_list.entity.user.loginDTO;
import br.com.eduardocouto.todo_list.entity.user.registerDTO;
import br.com.eduardocouto.todo_list.infra.security.TokenService;
import br.com.eduardocouto.todo_list.repository.UserRepository;


@RestController
@RequestMapping("auth" )
public class loginController {
    
@Autowired
AuthenticationManager authenticationManager;

@Autowired
private UserRepository userRepository;

@Autowired
private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody loginDTO data ){

        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Users)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody registerDTO data) {
        if(this.userRepository.findByLogin(data.login()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassowrd = new BCryptPasswordEncoder().encode(data.password());

        Users newUser = new Users(data.login(), encryptedPassowrd, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
