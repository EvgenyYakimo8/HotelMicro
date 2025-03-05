package by.com.gpsolutions.hotelmicro.mapper;

import by.com.gpsolutions.hotelmicro.dto.ContactsDto;
import by.com.gpsolutions.hotelmicro.entity.Contacts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactsMapper {

    ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);

    ContactsDto toDto(Contacts contacts);
    Contacts toEntity(ContactsDto contactsDto);

}
