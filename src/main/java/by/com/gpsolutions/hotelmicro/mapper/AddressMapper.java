package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.AddressDto;
import by.com.gpsolutions.hotelmicro.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);

}
