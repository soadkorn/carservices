package psuti.ru.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psuti.ru.backend.dto.UserDto;
import psuti.ru.backend.dto.UserInfo;
import psuti.ru.backend.entity.User;
import psuti.ru.backend.mapper.UserMapper;
import psuti.ru.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Transactional
    public UserDto loginUser(UserInfo dto) {
        return mapper.userToUserDto(repository.getUserByEmailAndPassword(dto.getEmail(), dto.getPassword()));
    }

    @Transactional
    public void createUser(UserDto dto) {
        repository.save(mapper.userDtoToUser(dto));
    }

    @Transactional
    public UserDto getUserByPublicId(Long publicId) {
        return mapper.userToUserDto(repository.getUserByPublicId(publicId));
    }

    @Transactional
    public void updateUser(UserDto dto) {
        User user = repository.getUserByPublicId(dto.getPublicId());
        repository.save(mapper.updateUserFromUserDto(dto, user));
    }

    @Transactional
    public void deleteUser(Long publicId) {
        repository.deleteUserByPublicId(publicId);
    }
}
