@echo off

set DB_URL=jdbc:postgresql://localhost:5432/postgres
set DB_DRIVER=org.postgresql.Driver
set DB_USERNAME=postgres
set DB_PASSWORD=bigbase

echo DB_URL=%DB_URL%
echo DB_DRIVER=%DB_DRIVER%
echo DB_USERNAME=%DB_USERNAME%
echo DB_PASSWORD=%DB_PASSWORD%

echo Environment variables have been set

mvn spring-boot:run