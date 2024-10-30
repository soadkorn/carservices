package psuti.ru.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psuti.ru.backend.dto.AddressDto;
import psuti.ru.backend.mapper.AddressMapper;
import psuti.ru.backend.repository.AddressRepository;
import psuti.ru.backend.repository.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final OrganizationRepository organizationRepository;
    private final AddressMapper mapper;

    public AddressDto getAddressByOrganization(Long organizationId) {
        var organization = organizationRepository.findById(organizationId);
        return mapper.addressToAddressDto(addressRepository.getAddressesByOrganization(organization.get()).get(0));
    }
}
