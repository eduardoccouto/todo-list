package br.com.eduardocouto.todo_list.security.jwt;



@Component
public class JwtUtils {
    
    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    
}
