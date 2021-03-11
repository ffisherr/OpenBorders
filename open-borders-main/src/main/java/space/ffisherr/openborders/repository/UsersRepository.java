package space.ffisherr.openborders.repository;

import org.springframework.data.repository.CrudRepository;
import space.ffisherr.openborders.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
