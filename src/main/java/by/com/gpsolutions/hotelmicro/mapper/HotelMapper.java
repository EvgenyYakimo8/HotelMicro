package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.HotelDto;
import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, ContactsMapper.class, ArrivalTimeMapper.class})
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDto toDto(Hotel hotel);

    Hotel toEntity(HotelDto hotelDto);

}
