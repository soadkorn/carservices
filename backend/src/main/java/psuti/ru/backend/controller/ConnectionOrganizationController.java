package psuti.ru.backend.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.service.ConnectionOrganizationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/connectionOrganization/")
public class ConnectionOrganizationController {

    private final ConnectionOrganizationService service;

    @PostMapping()
    public List<Object[]> getConnectionOrganizationsInStatus(@RequestParam String status) {
        return service.getAllConnectionInStatus(status);
    }
}
