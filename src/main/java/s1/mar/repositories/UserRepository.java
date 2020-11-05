package s1.mar.repositories;

import s1.mar.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Agent, Integer> {

    Optional<Agent> findUserByUsername(String username);
}
