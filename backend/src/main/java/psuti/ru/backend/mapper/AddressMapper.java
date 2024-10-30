package psuti.ru.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import psuti.ru.backend.dto.AddressDto;
import psuti.ru.backend.entity.Address;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    AddressDto addressToAddressDto(Address entity);
}
