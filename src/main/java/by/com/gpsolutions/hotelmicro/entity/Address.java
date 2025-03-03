package by.com.gpsolutions.hotelmicro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_address")
public class Address extends BaseId {

    private short houseNumber;
    private String street;
    private String city;
    private String country;
    private short postCode;
}
