package by.com.gpsolutions.hotelmicro.repository;

import by.com.gpsolutions.hotelmicro.entity.Hotel;
import by.com.gpsolutions.hotelmicro.repository.specification.HotelSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {

    default List<Hotel> searchHotels(String name, String brand, String city, String country, List<String> amenities) {
        Specification<Hotel> spec = Specification
                .where(HotelSpecifications.hasName(name))
                .and(HotelSpecifications.hasBrand(brand))
                .and(HotelSpecifications.hasCity(city))
                .and(HotelSpecifications.hasCountry(country))
                .and(HotelSpecifications.hasAmenities(amenities));

        return findAll(spec);
    }

    // Гистограмма по бренду
    @Query("SELECT h.brand AS key, COUNT(h) AS value FROM Hotel h GROUP BY h.brand")
    List<Object[]> getBrandHistogram();

    // Гистограмма по городу
    @Query("SELECT h.address.city AS key, COUNT(h) AS value FROM Hotel h GROUP BY h.address.city")
    List<Object[]> getCityHistogram();

    // Гистограмма по стране
    @Query("SELECT h.address.country AS key, COUNT(h) AS value FROM Hotel h GROUP BY h.address.country")
    List<Object[]> getCountryHistogram();

    // Гистограмма по удобствам
    @Query("SELECT a AS key, COUNT(h) AS value FROM Hotel h JOIN h.amenities a GROUP BY a")
    List<Object[]> getAmenitiesHistogram();

}
