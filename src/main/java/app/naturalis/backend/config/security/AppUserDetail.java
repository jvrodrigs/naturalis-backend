package app.naturalis.backend.config.security;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppUserDetail implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Funcionario> func = funcionarioRepository.findByEmail(email);

        Funcionario funcionario = func.orElseThrow(()  -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
        return new User(email, funcionario.getSenha(), getPermissions(funcionario));
    }

    private Collection<? extends GrantedAuthority> getPermissions(Funcionario funcionario) {
        Set<SimpleGrantedAuthority> auth = new HashSet<>();
        funcionario.getPermissaos().forEach(p ->
                auth.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase(Locale.ROOT))));
        return auth;
    }
}
