package by.com.gpsolutions.hotelmicro.dto;

import by.com.gpsolutions.hotelmicro.entity.Address;
import by.com.gpsolutions.hotelmicro.entity.ArrivalTime;
import by.com.gpsolutions.hotelmicro.entity.Contacts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private Address address;
    private Contacts contacts;
    private ArrivalTime arrivalTime;
    private List<String> amenities;

}