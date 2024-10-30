package psuti.ru.backend.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    private String subjectName;

    private String cityName;

    private String streetName;

    private String houseNumber;
}
