package s1.mar.services;

import s1.mar.Manifest;
import s1.mar.model.AgentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passEnc_BCrypt;

    @Autowired
    private SCryptPasswordEncoder passEnc_SCrypt;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        AgentDetails user = userDetailsService.loadUserByUsername(username);

        switch (user.getAgent().getAlgorithm()) {
            case BCRYPT:
                return checkPassword(user, password, passEnc_BCrypt);
            case SCRYPT:
                return checkPassword(user, password, passEnc_SCrypt);
        }

        throw new  BadCredentialsException(Manifest.Exception.badCredentials.getVal());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private Authentication checkPassword(AgentDetails user, String rawPassword, PasswordEncoder encoder) {
        if (encoder.matches(rawPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException(Manifest.Exception.badCredentials.getVal());
        }
    }
}
