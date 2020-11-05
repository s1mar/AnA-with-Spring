package s1.mar.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class AgentDetails implements UserDetails {

    private final Agent agent;

    public AgentDetails(Agent agent) {
        this.agent = agent;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return agent.getAuthorities().stream()
                   .map(a -> new SimpleGrantedAuthority(a.getName()))
                   .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return agent.getPassword();
    }

    @Override
    public String getUsername() {
        return agent.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public final Agent getAgent() {
        return agent;
    }
}
