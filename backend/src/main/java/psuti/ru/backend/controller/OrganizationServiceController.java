package psuti.ru.backend.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.dto.OrganizationServiceDto;
import psuti.ru.backend.service.ServiceDetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizationService/")
public class OrganizationServiceController {

    private final ServiceDetailService service;

    @PostMapping()
    public List<OrganizationServiceDto> getAllOrganizationServiceDetails(Long organizationId) {
        return service.getServiceDetailsByOrganizationId(organizationId);
    }
}
