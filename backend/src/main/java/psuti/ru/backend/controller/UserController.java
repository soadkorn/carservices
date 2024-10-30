package psuti.ru.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import psuti.ru.backend.dto.UserDto;
import psuti.ru.backend.dto.UserInfo;
import psuti.ru.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class UserController {

    private final UserService service;

    @PostMapping("login/")
    public UserDto loginUser(@RequestBody UserInfo dto) {
        return service.loginUser(dto);
    }

    @GetMapping
    public UserDto getUserById(@RequestParam Long publicId) {
        return service.getUserByPublicId(publicId);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto dto) {
        service.createUser(dto);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto dto) {
        service.updateUser(dto);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long publicId) {
        service.deleteUser(publicId);
    }
}
