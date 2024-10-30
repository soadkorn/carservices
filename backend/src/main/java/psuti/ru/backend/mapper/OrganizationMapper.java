package psuti.ru.backend.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import psuti.ru.backend.dto.OrganizationDto;
import psuti.ru.backend.dto.OrganizationInfo;
import psuti.ru.backend.entity.Organization;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrganizationMapper {

    Organization organizationDtoToOrganization(OrganizationDto dto);

    Organization organizationInfoToOrganization(OrganizationInfo dto);

    OrganizationDto organizationToOrganizationDto(Organization entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Organization updateOrganizationFromOrganizationInfo(OrganizationInfo dto, @MappingTarget Organization entity);
}