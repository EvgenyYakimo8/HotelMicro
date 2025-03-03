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
@Table(name = "tb_arrival_time")
public class ArrivalTime extends BaseId {

    private String checkIn;
    private String checkOut;

}
