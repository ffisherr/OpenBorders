package space.ffisherr.openborders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import space.ffisherr.openborders.entity.Countries;

import java.util.List;

public interface CountriesRepository extends CrudRepository<Countries, Long> {

    @Query("select c.name from Countries c where c.isAvailable = true")
    List<String> findAllOpenedCountriesNames();

}
