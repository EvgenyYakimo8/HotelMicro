package by.com.gpsolutions.hotelmicro.service;

import by.com.gpsolutions.hotelmicro.entity.Hotel;
import by.com.gpsolutions.hotelmicro.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Отель не найден"));
    }

    public List<Hotel> searchHotels(String name, String brand, String city, String country, List<String> amenities) {
        return hotelRepository.searchHotels(name, brand, city, country, amenities);
    }

    public Map<String, Long> getHistogram(String param) {
        List<Object[]> result = switch (param.toLowerCase()) {
            case "brand" -> hotelRepository.getBrandHistogram();
            case "city" -> hotelRepository.getCityHistogram();
            case "country" -> hotelRepository.getCountryHistogram();
            case "amenities" -> hotelRepository.getAmenitiesHistogram();
            default -> throw new IllegalArgumentException("Неподдерживаемый параметр: " + param);
        };

        return result.stream()
                .collect(Collectors.toMap(
                        arr -> (String) arr[0], // Ключ (brand, city, country, amenity)
                        arr -> (Long) arr[1]   // Значение (количество отелей)
                ));
    }

}
