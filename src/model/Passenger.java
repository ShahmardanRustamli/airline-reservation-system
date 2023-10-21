package model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger {
    long id;
    String  name;
    String surname;
    int age;
    LocalDate birthday;
    String phoneNumber;
    String email;
    String passportNumber;
    String gender;
    double balance;
    long ticketId;
    String seatNumber;

}
