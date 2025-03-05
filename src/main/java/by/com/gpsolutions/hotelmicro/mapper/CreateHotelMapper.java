package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.CreateHotelRequestDto;
import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, ContactsMapper.class, ArrivalTimeMapper.class})
public interface CreateHotelMapper {

    CreateHotelMapper INSTANCE = Mappers.getMapper(CreateHotelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "contacts", target = "contacts")
    @Mapping(source = "arrivalTime", target = "arrivalTime")
    Hotel toEntity(CreateHotelRequestDto CreateHotelRequestDto);

}
