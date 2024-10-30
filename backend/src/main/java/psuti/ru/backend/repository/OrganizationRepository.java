package psuti.ru.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization getOrganizationByInn(String inn);

    void deleteOrganizationByInn(String inn);
}
