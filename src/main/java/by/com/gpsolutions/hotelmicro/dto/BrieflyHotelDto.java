package by.com.gpsolutions.hotelmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrieflyHotelDto {

    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;

}
