package youmssoft.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.User;

public interface UsersRepository extends JpaRepository<User, String> {

}
