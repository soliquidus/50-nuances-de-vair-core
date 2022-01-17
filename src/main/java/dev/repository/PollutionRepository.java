package dev.repository;

import dev.entity.Pollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PollutionRepository extends JpaRepository<Pollution,Integer> {
    /**
     * building the database.
     * @Bean verification of the current data of the day
     * @param dateNow
     * @return save in database
     */
    //public Optional<Pollution> findByDateOrDateDay(LocalDate dateNow);

    /**
     * search air pollution of the city
     * @param cityName of the City
     * @return City Pollution
     */
    //public List<Pollution> findAllByCityName(String cityName);
}
