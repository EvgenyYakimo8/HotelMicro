package by.com.gpsolutions.hotelmicro.controller;

import by.com.gpsolutions.hotelmicro.dto.BrieflyHotelDto;
import by.com.gpsolutions.hotelmicro.dto.CreateHotelRequestDto;
import by.com.gpsolutions.hotelmicro.dto.HotelDto;
import by.com.gpsolutions.hotelmicro.entity.Hotel;
import by.com.gpsolutions.hotelmicro.mapper.BrieflyHotelMapper;
import by.com.gpsolutions.hotelmicro.mapper.CreateHotelMapper;
import by.com.gpsolutions.hotelmicro.mapper.HotelMapper;
import by.com.gpsolutions.hotelmicro.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;
    private final BrieflyHotelMapper brieflyHotelMapper;
    private final CreateHotelMapper createHotelMapper;

    public HotelController(HotelService hotelService, HotelMapper hotelMapper, BrieflyHotelMapper brieflyHotelMapper, CreateHotelMapper createHotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
        this.brieflyHotelMapper = brieflyHotelMapper;
        this.createHotelMapper = createHotelMapper;
    }

    @GetMapping
    public List<BrieflyHotelDto> getAllHotels() {
        List<Hotel> hotels = hotelService.findAll();
        return hotels.stream()
                .map(brieflyHotelMapper::toBrieflyDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BrieflyHotelDto createHotel(@RequestBody CreateHotelRequestDto createHotelRequestDto) {
        Hotel hotel = createHotelMapper.toEntity(createHotelRequestDto);
        Hotel savedHotel = hotelService.save(hotel);
        return brieflyHotelMapper.toBrieflyDto(savedHotel);
    }

    @GetMapping("/{id}")
    public HotelDto getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        return hotelMapper.toDto(hotel);
    }

    @PostMapping("/{id}/amenities")
    public BrieflyHotelDto addAmenities(@PathVariable Long id, @RequestBody List<String> amenities) {
        Hotel hotel = hotelService.findById(id);
        hotel.getAmenities().addAll(amenities);
        Hotel updatedHotel = hotelService.save(hotel);
        return brieflyHotelMapper.toBrieflyDto(updatedHotel);
    }

    @GetMapping("/search")
    public List<BrieflyHotelDto> searchHotels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) List<String> amenities) {

        List<Hotel> hotels = hotelService.searchHotels(name, brand, city, country, amenities);
        return hotels.stream()
                .map(brieflyHotelMapper::toBrieflyDto)
                .collect(Collectors.toList());
    }

}
