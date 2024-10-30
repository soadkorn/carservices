package psuti.ru.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import psuti.ru.backend.dto.OrganizationServiceDto;
import psuti.ru.backend.entity.ServiceDetail;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ServiceDetailMapper {


    @Mapping(target = "serviceDetailName", source = "name")
    @Mapping(target = "serviceDetailDuration", source = "duration")
    @Mapping(target = "serviceDetailCost", source = "cost")
    OrganizationServiceDto serviceDetailToOrganizationServiceDto(ServiceDetail entity);
}
