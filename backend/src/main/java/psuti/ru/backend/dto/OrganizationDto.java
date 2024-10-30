package psuti.ru.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private Long id;

    private String fullName;

    private String shortName;

    private String inn;

    private String kpp;

    private String ogrn;

    private String addInfo;

    /**
     * Почта ответственного за организацию лица. По ней производится поиск пользователя в БД
     */
    private String responsiblePersonEmail;
}
