package by.com.gpsolutions.hotelmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer houseNumber;
    private String street;
    private String city;
    private String country;
    private Integer postCode;

}
