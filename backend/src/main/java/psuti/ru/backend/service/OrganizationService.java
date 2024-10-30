package psuti.ru.backend.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psuti.ru.backend.dto.OrganizationDto;
import psuti.ru.backend.dto.OrganizationInfo;
import psuti.ru.backend.entity.Organization;
import psuti.ru.backend.mapper.OrganizationMapper;
import psuti.ru.backend.repository.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationMapper mapper;
    private final OrganizationRepository repository;

    @Transactional
    public void createOrganization(OrganizationInfo dto) {
        repository.save(mapper.organizationInfoToOrganization(dto));
    }

    @Transactional
    public OrganizationDto getOrganizationByInn(String inn) {
        return mapper.organizationToOrganizationDto(repository.getOrganizationByInn(inn));
    }

    @Transactional
    public List<OrganizationDto> getAllOrganizations() {
        return repository.findAll().stream()
                .map(mapper::organizationToOrganizationDto)
                .toList();
    }

    @Transactional
    public void updateOrganization(OrganizationInfo dto) {
        Organization organization = repository.getOrganizationByInn(dto.getInn());
        repository.save(mapper.updateOrganizationFromOrganizationInfo(dto, organization));
    }

    @Transactional
    public void deleteOrganization(String inn) {
        repository.deleteOrganizationByInn(inn);
    }
}
