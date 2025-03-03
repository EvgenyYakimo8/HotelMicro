@echo off

set DB_URL=jdbc:h2:file:./data/hotelMicro
set DB_DRIVER=org.h2.Driver
set DB_USERNAME=sa
set DB_PASSWORD=sa

echo DB_URL=%DB_URL%
echo DB_DRIVER=%DB_DRIVER%
echo DB_USERNAME=%DB_USERNAME%
echo DB_PASSWORD=%DB_PASSWORD%

echo Environment variables have been set

mvn spring-boot:run