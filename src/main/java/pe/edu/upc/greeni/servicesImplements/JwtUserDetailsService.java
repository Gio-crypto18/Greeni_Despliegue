package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Usuario;
import pe.edu.upc.greeni.repositories.IUsuarioRepository;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repo.findOneByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no existe: " + email);
        }


        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol().getTipo());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isActivo(),
                true,
                true,
                true,
                Collections.singletonList(authority)
        );
    }
}
