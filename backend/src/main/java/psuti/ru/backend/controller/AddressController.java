package psuti.ru.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.dto.AddressDto;
import psuti.ru.backend.service.AddressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address/")
public class AddressController {

    private final AddressService service;

    @PostMapping()
    public AddressDto getAddressByOrganization(@RequestParam Long organizationId) {
        return service.getAddressByOrganization(organizationId);
    }
}
