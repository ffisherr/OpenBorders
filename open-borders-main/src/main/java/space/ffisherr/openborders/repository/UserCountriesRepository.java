package space.ffisherr.openborders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import space.ffisherr.openborders.entity.UserWantedCountries;

import java.util.List;

public interface UserCountriesRepository extends CrudRepository<UserWantedCountries, Long> {

    @Query("select c from UserWantedCountries c left join Countries c1 on c.name = c1.name " +
            "where c.user.id = :userId and c1.isAvailable = true")
    List<String> findAllOpenedCountriesNames(@Param("userId")Long userId);

}
