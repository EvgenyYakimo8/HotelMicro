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
@Table(name = "tb_contacts")
public class Contacts extends BaseId {

    private String phone;
    private String email;

}
