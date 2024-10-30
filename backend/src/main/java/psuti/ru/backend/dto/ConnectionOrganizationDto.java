package psuti.ru.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ConnectionOrganizationDto {
    @JsonProperty("organization_shortname")
    private String organizationShortName;

    @JsonProperty("date_begin")
    private LocalDate dateBegin;

    @JsonProperty("reg_number")
    private String regNumber;
}