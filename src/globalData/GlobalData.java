package globalData;
import model.Airport;
import model.Flight;
import model.Passenger;
import model.Ticket;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static Airport airport = Airport.builder()
            .id(1)
            .name("Heydar Aliyev International Airport")
            .area("Baku, Azerbaijan 20KM away from Baku")
            .totalAmount(BigDecimal.valueOf(100000))
            .build();

    public static List<Passenger> passengerList = new ArrayList<>();
    public static List<Flight> flightList = new ArrayList<>();
    public static List<Ticket> ticketList = new ArrayList<>();

}
