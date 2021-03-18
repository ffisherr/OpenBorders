package space.ffisherr.openborders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import space.ffisherr.openborders.entity.Countries;
import space.ffisherr.openborders.entity.UserWantedCountries;

import java.util.List;
import java.util.Optional;

public interface UserCountriesRepository extends CrudRepository<UserWantedCountries, Long> {

    @Query("select c.name from UserWantedCountries c left join Countries c1 on c.name = c1.name " +
            "where c.user.id = :userId and c1.isAvailable = true")
    List<String> findAllOpenedCountriesNames(@Param("userId")Long userId);

    @Query("select c from Countries c where c.name = :countryName")
    Optional<Countries> findByName(@Param("countryName") String countryName);

    @Query("select c from UserWantedCountries c where c.user.id = :userId")
    List<UserWantedCountries> findAllByUser(@Param("userId") Long userId);
}
