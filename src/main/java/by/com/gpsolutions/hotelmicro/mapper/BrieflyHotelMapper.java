package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.BrieflyHotelDto;
import by.com.gpsolutions.hotelmicro.entity.Address;
import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface BrieflyHotelMapper {

    BrieflyHotelMapper INSTANCE = Mappers.getMapper(BrieflyHotelMapper.class);

    @Mapping(source = "address.street", target = "address")
    @Mapping(source = "contacts.phone", target = "phone")
    BrieflyHotelDto toBrieflyDto(Hotel hotel);

    @AfterMapping
    default void afterMapping(Hotel hotel, @MappingTarget BrieflyHotelDto brieflyHotelDto) {
        Address address = hotel.getAddress();
        if (address != null) {
            String formattedAddress = String.format("%d %s, %s, %d, %s",
                    address.getHouseNumber(),
                    address.getStreet(),
                    address.getCity(),
                    address.getPostCode(),
                    address.getCountry());
            brieflyHotelDto.setAddress(formattedAddress);
        }
    }

}
