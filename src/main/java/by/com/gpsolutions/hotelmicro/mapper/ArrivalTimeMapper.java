package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.ArrivalTimeDto;
import by.com.gpsolutions.hotelmicro.entity.ArrivalTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArrivalTimeMapper {

    ArrivalTimeMapper INSTANCE = Mappers.getMapper(ArrivalTimeMapper.class);

    ArrivalTimeDto toDto(ArrivalTime arrivalTime);
    ArrivalTime toEntity(ArrivalTimeDto arrivalTimeDto);

}
