package psuti.ru.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psuti.ru.backend.entity.Address;
import psuti.ru.backend.entity.Organization;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> getAddressesByOrganization(Organization organization);
}
