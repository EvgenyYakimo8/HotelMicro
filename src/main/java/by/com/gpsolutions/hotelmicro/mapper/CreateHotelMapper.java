package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.CreateHotelRequestDto;
import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, ContactsMapper.class, ArrivalTimeMapper.class})
public interface CreateHotelMapper {

    CreateHotelMapper INSTANCE = Mappers.getMapper(CreateHotelMapper.class);

    Hotel toEntity(CreateHotelRequestDto CreateHotelRequestDto);

}
