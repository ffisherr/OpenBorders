package space.ffisherr.openborders.repository;

import org.springframework.data.repository.CrudRepository;
import space.ffisherr.openborders.entity.Countries;

public interface CountriesRepository extends CrudRepository<Countries, Long> {
}
