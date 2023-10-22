package helper;
import enums.ExceptionEnum;
import exceptions.ApplicationException;
import globalData.GlobalData;
import model.Flight;
import model.Passenger;
import model.Ticket;
import util.InputUtil;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static enums.ExceptionEnum.TICKET_NOT_FOUND_EXCEPTION;

public class ServiceHelper {
    static long flightId;
    static long passengerId;
    public static Flight fillFlight(){
        try{
            UUID flightName = UUID.randomUUID();
            String randomName = flightName.toString().substring(0,5).toUpperCase();
            System.out.println("------------| ADD FLIGHT |------------");
            String name = randomName;
            String source = InputUtil.getInstance().inputString("Enter The Source:").toUpperCase();
            String destination = InputUtil.getInstance().inputString("Enter The Destination:").toUpperCase();
            LocalDate date = dateFormat("Enter The Fight Date: ");
            LocalTime startTime = timeFormat("Enter The Flight Hour:");
            LocalTime reachTime = timeFormat("Enter The Reach Time:");
            double flightPrice = InputUtil.getInstance().inputDouble("Enter The Flight Price:");
            return Flight.builder()
                    .id(++flightId)
                    .name(name)
                    .source(source)
                    .destination(destination)
                    .date(date)
                    .startTime(startTime)
                    .reachTime(reachTime)
                    .price(flightPrice)
                    .build();
        }catch (ApplicationException ex){
            throw new ApplicationException(ExceptionEnum.UNSUCCESSFULLY_REGISTER);
        }

    }
    private static LocalDate dateFormat(String s) {
        String stringDate = InputUtil.getInstance().inputString(s+ " - (FORMAT ONLY: yyyy/MM/dd): ");
        String[] splitDate = stringDate.split("/");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        return LocalDate.of(year,month,day);
    }
    private static LocalTime timeFormat(String s){
        String stringHour = InputUtil.getInstance().inputString(s);
        return LocalTime.of(Integer.parseInt(stringHour),0,0);
    }

    public static Passenger fillPassenger(){
        System.out.println("------------| PASSENGER REGISTER | ------------");
        String name = InputUtil.getInstance().inputString("Enter Your Name:").toUpperCase();
        String surname = InputUtil.getInstance().inputString("Enter Your Surname:").toUpperCase();
        int age = InputUtil.getInstance().inputInt("Enter Your Age:");
        LocalDate birthday = dateFormat("Enter Your Birthday: ");
        String phoneNumber = InputUtil.getInstance().inputString("Enter Your Phone Number:");
        String email = InputUtil.getInstance().inputString("Enter Your email Address:").toUpperCase();
        String passportNumber = InputUtil.getInstance().inputString("Enter Your Passport Number:").toUpperCase();
        String gender = InputUtil.getInstance().inputString("Enter Your Gender:").toUpperCase();
        double passengerBalance = 2000;
        long ticketId = flightId;
        String seatNumber = randomSeat();
        return Passenger.builder()
                .id(++passengerId)
                .name(name)
                .surname(surname)
                .age(age)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .email(email)
                .passportNumber(passportNumber)
                .gender(gender)
                .balance(passengerBalance)
                .ticketId(ticketId)
                .seatNumber(seatNumber)
                .build();
    }
    public static String randomSeat() {
        Random random = new Random();
        return ("B-" + random.nextInt(101,301));
    }
    public static void showFlights(){
        if (GlobalData.flightList.isEmpty()){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND_EXCEPTION);
        }
        GlobalData.flightList.stream()
                .forEach(System.out::println);
    }

    public static void searchHelper(){
        if (GlobalData.flightList.isEmpty()){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND_EXCEPTION);
        }
        long flightId = InputUtil.getInstance().inputLong("Enter The Flight ID to Search:");
        GlobalData.flightList.stream()
                .filter(flight -> flight.getId()==flightId)
                .forEach(System.out::println);
    }

    public static Ticket searchTicket(long cancelId, List<Ticket> tickets){
        return tickets.stream()
                .filter(n -> n.getId() == cancelId)
                .findFirst()
                .orElseThrow(() ->new ApplicationException(TICKET_NOT_FOUND_EXCEPTION));


    }
    public static void passengerInfo(Passenger passenger){
        System.out.println(passenger.toString());
    }
}
