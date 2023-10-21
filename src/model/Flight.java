package model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flight {
    long id;
    String name;
    String source;
    String destination;
    LocalDate date;
    LocalTime startTime;
    LocalTime reachTime;
    double price;
}
