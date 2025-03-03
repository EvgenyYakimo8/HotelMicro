package by.com.gpsolutions.hotelmicro.repository;

import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
