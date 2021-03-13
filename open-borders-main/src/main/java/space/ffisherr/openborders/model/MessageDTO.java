package space.ffisherr.openborders.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDTO {

    private Long id;
    private Long userId;
    public String message;
    private Boolean isFromUser;
    private Timestamp timestamp;

}
