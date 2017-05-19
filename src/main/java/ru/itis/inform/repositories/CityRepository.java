package ru.itis.inform.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.inform.models.City;

/**
 * Created by Natalia on 05.03.17.
 */
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query(value = "select city.id from City city where city.name = :cityName")
    public int getCityId(@Param("cityName") String cityName);

}
