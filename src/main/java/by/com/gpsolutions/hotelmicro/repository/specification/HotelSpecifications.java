package by.com.gpsolutions.hotelmicro.repository.specification;

import by.com.gpsolutions.hotelmicro.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.List;

public class HotelSpecifications {

    public static Specification<Hotel> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                StringUtils.isEmpty(name) ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Hotel> hasBrand(String brand) {
        return (root, query, criteriaBuilder) ->
                StringUtils.isEmpty(brand) ? null : criteriaBuilder.like(root.get("brand"), "%" + brand + "%");
    }

    public static Specification<Hotel> hasCity(String city) {
        return (root, query, criteriaBuilder) ->
                StringUtils.isEmpty(city) ? null : criteriaBuilder.like(root.get("address").get("city"), "%" + city + "%");
    }

    public static Specification<Hotel> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                StringUtils.isEmpty(country) ? null : criteriaBuilder.like(root.get("address").get("country"), "%" + country + "%");
    }

    public static Specification<Hotel> hasAmenities(List<String> amenities) {
        return (root, query, criteriaBuilder) ->
                amenities == null || amenities.isEmpty() ? null : root.get("amenities").in(amenities);
    }

}
