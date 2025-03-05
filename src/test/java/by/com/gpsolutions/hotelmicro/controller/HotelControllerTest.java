package by.com.gpsolutions.hotelmicro.controller;

import by.com.gpsolutions.hotelmicro.entity.Hotel;
import by.com.gpsolutions.hotelmicro.service.HotelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import(HotelControllerTest.HotelServiceMockConfig.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Здесь будет автоматически внедрён наш моковая реализация HotelService,
    // которую мы создадим в TestConfiguration.
    @Autowired
    private HotelService hotelService;

    // Передаём значения переменных окружения, аналогичные тем, что устанавливаются через set-env-h2.bat.
    @DynamicPropertySource
    static void dynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("DB_URL", () -> "jdbc:h2:file:./data/hotelMicro");
        registry.add("DB_DRIVER", () -> "org.h2.Driver");
        registry.add("DB_USERNAME", () -> "sa");
        registry.add("DB_PASSWORD", () -> "sa");
    }

    // Тестовая конфигурация, регистрирующая мок для HotelService.
    @TestConfiguration
    static class HotelServiceMockConfig {
        @Bean
        public HotelService hotelService() {
            return Mockito.mock(HotelService.class);
        }
    }

    @Test
    public void testGetAllHotels() throws Exception {
        // Создаем тестовую сущность Hotel
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("DoubleTree by Hilton Minsk");
        hotel.setDescription("Description");
        // Прочие поля (address, contacts) в данном примере остаются null

        // Настраиваем поведение мока: метод findAll() возвращает список из одного отеля
        Mockito.when(hotelService.findAll()).thenReturn(Collections.singletonList(hotel));

        String expectedJson = "[{\"id\":1,\"name\":\"DoubleTree by Hilton Minsk\",\"description\":\"Description\",\"address\":null,\"phone\":null}]";

        // Выполняем GET-запрос к эндпоинту /hotels и проверяем статус и JSON-ответ
        mockMvc.perform(get("/hotels").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
