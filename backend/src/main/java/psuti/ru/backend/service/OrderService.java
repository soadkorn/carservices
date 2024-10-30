package psuti.ru.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psuti.ru.backend.dto.OrderDto;
import psuti.ru.backend.entity.Address;
import psuti.ru.backend.entity.ServiceRequest;
import psuti.ru.backend.repository.AddressRepository;
import psuti.ru.backend.repository.OrganizationRepository;
import psuti.ru.backend.repository.ServiceDetailRepository;
import psuti.ru.backend.repository.ServiceRequestRepository;
import psuti.ru.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final AddressRepository addressRepository;
    private final ServiceDetailRepository detailRepository;
    private final ServiceRequestRepository requestRepository;

    public void processOrder(OrderDto orderDto) {
        var user = userRepository.getUserByEmail(orderDto.getClientEmail());
        var organization = organizationRepository.findById(orderDto.getOrganizationId()).get();
        var address = addressRepository.findById(orderDto.getOrganizationAddressId());
        var serviceDetails = detailRepository.getServiceDetailsByIdIn(orderDto.getServiceDetailsIds());

        requestRepository.save(new ServiceRequest(
                user,
                organization,
                orderDto.getDateOfOrder(),
                createOrderAddInfo(organization.getShortName(), orderDto.getServiceDetailName(), address.get()),
                serviceDetails));
    }

    private String createOrderAddInfo(String organizationShortName, String serviceDetailName,
                                      Address address) {
        var addInfo = new StringBuilder(organizationShortName).append(", ").append(serviceDetailName);
        if (address != null) {
            addInfo.append(", ").append(address.getSubjectName())
                    .append(", г.").append(address.getCityName())
                    .append(", ").append(address.getStreetName())
                    .append(" ").append(address.getHouseNumber());
        }
        return addInfo.toString();
    }
}
