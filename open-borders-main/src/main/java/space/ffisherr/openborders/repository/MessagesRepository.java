package space.ffisherr.openborders.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import space.ffisherr.openborders.entity.Messages;

public interface MessagesRepository extends CrudRepository<Messages, Long> {

    Slice<Messages> findByUserId(Long userId, Pageable pageable);

}
