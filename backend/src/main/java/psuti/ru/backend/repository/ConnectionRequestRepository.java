package psuti.ru.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.ConnectionRequest;

@Repository
public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, Long> {

    @Query(nativeQuery = true,
            value = "SELECT date_begin, reg_number, organization_short_name " +
            "from connection_request " +
            "join organization o on o.organization_id = connection_request.organization_id " +
            "where status like :status")
    List<Object[]> getConnectionRequestsByStatus(String status);
}
