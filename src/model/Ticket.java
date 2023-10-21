package model;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    long id;
    long ticketNumber;
    String source;
    String destination;
    double price;
    long flightId;
}
