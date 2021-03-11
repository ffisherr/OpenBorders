package space.ffisherr.openborders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Messages {

    @Id
    private Long id;
    private String message;
    private Long userId;
    private Boolean isFrom;
    private Timestamp sentAt;

}
