package s1.mar.services;

import s1.mar.Manifest;
import s1.mar.model.Agent;
import s1.mar.model.AgentDetails;
import s1.mar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AgentDetails loadUserByUsername(String username) {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException(Manifest.Exception.userNameNotFoundExceptionMsg.getVal());

        Agent agent = userRepository.findUserByUsername(username).orElseThrow(s);

        return new AgentDetails(agent);
    }
}
