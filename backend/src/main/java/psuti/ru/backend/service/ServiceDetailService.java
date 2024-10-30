package psuti.ru.backend.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psuti.ru.backend.dto.OrganizationServiceDto;
import psuti.ru.backend.mapper.ServiceDetailMapper;
import psuti.ru.backend.repository.ServiceDetailRepository;

@Service
@RequiredArgsConstructor
public class ServiceDetailService {

    private final ServiceDetailRepository repository;
    private final ServiceDetailMapper mapper;

    public List<OrganizationServiceDto> getServiceDetailsByOrganizationId(Long organizationId) {
        return repository.getServiceDetailsByOrganization(organizationId)
                .stream()
                .map(mapper::serviceDetailToOrganizationServiceDto)
                .toList();
    }
}
