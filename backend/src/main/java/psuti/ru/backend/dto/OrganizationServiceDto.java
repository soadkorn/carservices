package psuti.ru.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrganizationServiceDto {

    @JsonProperty("service_detail_cost")
    private BigDecimal serviceDetailCost;

    @JsonProperty("service_detail_duration")
    private Integer serviceDetailDuration;

    @JsonProperty("service_detail_name")
    private String serviceDetailName;
}
