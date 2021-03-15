package space.ffisherr.openborders.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import space.ffisherr.openborders.entity.Messages;

import java.util.Optional;

public interface MessagesRepository extends CrudRepository<Messages, Long> {

    Slice<Messages> findByUserId(Long userId, Pageable pageable);

    @Query("select m from Messages m where m.id = (select max(m1.id) from Messages m1 where m1.isFrom = true)")
    Optional<Messages> getLastUserMessage(@Param("userId") Long userId);
}
