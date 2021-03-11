package space.ffisherr.openborders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Users {

    @Id
    private Long id;
    private String email;
    private String pwd;

}
