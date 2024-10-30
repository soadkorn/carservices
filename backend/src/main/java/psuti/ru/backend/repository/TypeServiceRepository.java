package psuti.ru.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.TypeService;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Long> {

}
