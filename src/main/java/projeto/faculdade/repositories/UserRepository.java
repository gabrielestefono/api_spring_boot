package projeto.faculdade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.faculdade.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
