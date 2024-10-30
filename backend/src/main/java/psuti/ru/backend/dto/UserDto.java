package psuti.ru.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long publicId;
    private String name;
    private String surName;
    private String patronymic;
    private String phoneNumber;
    private String email;
    private String addInfo;
}
