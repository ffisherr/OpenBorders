package space.ffisherr.openborders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Countries {

    @Id
    private Long id;
    private String name;
    private boolean isAvailable;

}
