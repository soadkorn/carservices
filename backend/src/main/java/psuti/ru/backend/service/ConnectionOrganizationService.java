package psuti.ru.backend.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psuti.ru.backend.repository.ConnectionRequestRepository;

@Service
@RequiredArgsConstructor
public class ConnectionOrganizationService {

    private final ConnectionRequestRepository connectionRepository;

    @Transactional
    public List<Object[]> getAllConnectionInStatus(String status) {

        return connectionRepository.getConnectionRequestsByStatus(status);
    }
}
