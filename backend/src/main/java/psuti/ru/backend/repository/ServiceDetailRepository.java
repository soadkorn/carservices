package psuti.ru.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.ServiceDetail;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Long> {

    @Query("SELECT sd FROM ServiceDetail sd WHERE sd.organization.id = :organizationId")
    List<ServiceDetail> getServiceDetailsByOrganization(Long organizationId);

    List<ServiceDetail> getServiceDetailsByIdIn(List<Long> serviceDetailIds);
}
