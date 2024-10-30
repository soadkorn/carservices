package psuti.ru.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {

    @JsonProperty("client_email")
    private String clientEmail;

    @JsonProperty("service_detail_name")
    private String serviceDetailName;

    @JsonProperty("organization_id")
    private Long organizationId;

    @JsonProperty("service_details_ids")
    private List<Long> serviceDetailsIds;

    @JsonProperty("date_of_order")
    private LocalDateTime dateOfOrder;

    @JsonProperty("organization_address_id")
    private Long organizationAddressId;
}