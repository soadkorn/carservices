package psuti.ru.backend.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.dto.OrganizationDto;
import psuti.ru.backend.dto.OrganizationInfo;
import psuti.ru.backend.service.OrganizationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organization/")
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping
    public OrganizationDto getOrganizationById(@RequestParam String inn) {
        return service.getOrganizationByInn(inn);
    }

    @GetMapping("all/")
    public List<OrganizationDto> getAllOrganizations(){
        return service.getAllOrganizations();
    }
    @PostMapping
    public void saveOrganization(@RequestBody OrganizationInfo dto) {
        service.createOrganization(dto);
    }

    @PutMapping
    public void updateOrganization(@RequestBody OrganizationInfo dto) {
        service.updateOrganization(dto);
    }

    @DeleteMapping
    public void deleteOrganization(@RequestParam String inn) {
        service.deleteOrganization(inn);
    }
}
