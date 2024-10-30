package psuti.ru.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.dto.OrderDto;
import psuti.ru.backend.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order/")
public class OrderController {

    private final OrderService service;

    @PostMapping()
    public void processOrder(@RequestBody OrderDto dto) {
        service.processOrder(dto);
    }
}
