Для запуска приложения «Из коробки» в терминале введите cmd.exe **/c set-env-h2.bat**
Для завершения работы приложения зажмите **Ctrl+C введите Y и нажмите Enter**.

Приложение запускается из консоли при помощи команды mvn spring-boot:run (она входит в файл set-env-h2.bat )
Порт для запуска: 8092
У всех методов общий префикс "property-view". Реализовано через конфигурацию server.servlet.context-path=/property-view Например: http://localhost:8092/property-view/h2-console (активирована консоль для работы с H2 БД).

**Используемые технологии:**
	Maven, Java 21, Spring Boot, Spring JPA, Liquibase, Mapstruct, Lombok, H2, Postgres, Swagger.
 
В качестве базы данных: H2, Postgres + можно легко добавить другие варианты. 
Добавлены тесты;
Подключены документации Swagger: - реализовано.
доступность по пути http://localhost:8092/property-view/swagger-ui.html и http://localhost:8092/property-view/api-docs;
Использование паттернов проектирования – реализовано.
Разделения на слои – реализовано.
Возможности "быстро" переключиться с H2 на другую базу (MySQL, PostgreSQL, Mongo и т.д) – реализовано.


**Ручное тестирование осуществлялось с помощью Postman:**
1.	POST   localhost:8092/property-view/hotels

{
            "name": "DoubleTree by Hilton Minsk",
            "description": "The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...",
            "brand": "Hilton",
            "address": 
                {
                    "houseNumber": 9,
                    "street": "Pobediteley Avenue",
                    "city": "Minsk",
                    "country": "Belarus",
                    "postCode": 220004
                },
            "contacts": 
                {
                    "phone": "+375 17 309-80-00",
                    "email": "doubletreeminsk.info@hilton.com"
                },
            "arrivalTime":
                {
                    "checkIn": "14:00",
                    "checkOut": "12:00"
                }
        }

2.	GET   localhost:8092/property-view/hotels
3.	GET   localhost:8092/property-view/hotels/1
4.	GET   localhost:8092/property-view/hotels/search?city=Minsk
5.	POST localhost:8092/property-view/hotels/3/amenities

  [
              "Free parking",
              "Free WiFi",
              "Non-smoking rooms",
              "Concierge",
              "On-site restaurant",
              "Fitness center",
              "Pet-friendly rooms",
              "Room service",
              "Business center",
              "Meeting rooms"
          ]
          
6.	GET localhost:8092/property-view/histogram/city
7.	GET localhost:8092/property-view/histogram/amenities


---------------------------------------------------------------------------------------------------------------------------------------------

Maven должен быть установлен локально на компьютере для работы команд в терминале.
В приложении используется файловая база данных H2 (Расположение ./data/hotelMicro). При запуске set-env-h2.bat вносятся параметры в переменные среды логин с паролем.
(предварительно скачайте в Idea драйвер для H2, при попытке подключение к базе в Idea она предложит его скачать)

Перед запуском в файле application.properties укажите параметр профиля h2 либо postrgres (по умолчанию стоит h2). Если вы используете другую БД вам требуется создать два файла 1. Конфигурацию БД, используйте файл application-postgres.properties как пример. 2. .bat файл для запуска с нужными параметрами входа в БД, используйте файл set-env-postgres.bat как пример.

Запуск приложения осуществляется через терминал в Intelige Idea командами cmd.exe /c set-env-h2.bat (по умолчанию) или set-env-postgres.bat(но тут установите ваши данные пользователя пароля и URL).

----------------------------------------------------------------------------------------------------------------------------------------------Добавлены set-env-h2.bat и set-env-postgres.bat для запуска через командную строку с предустановкой переменных среды после выбора профиля для запуска.

