package s1.mar.model;



import s1.mar.Manifest;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Manifest.EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manifest.EncryptionAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Manifest.EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
