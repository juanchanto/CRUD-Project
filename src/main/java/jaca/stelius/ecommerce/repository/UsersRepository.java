package jaca.stelius.ecommerce.repository;

import jaca.stelius.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
