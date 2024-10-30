package psuti.ru.backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);

    User getUserByPublicId(Long clientId);

    void deleteUserByPublicId(Long clientId);
}
