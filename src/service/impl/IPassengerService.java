package service.impl;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ApplicationException;
import globalData.GlobalData;
import model.Flight;
import model.Passenger;
import model.Ticket;
import service.PassengerService;
import util.InputUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import static helper.ServiceHelper.*;
import static util.MenuUtil.*;

public class IPassengerService implements PassengerService {

    static long ticketId;
    @Override
    public void viewFlights() {
        showFlights();
        long id = InputUtil.getInstance().inputLong("Enter The ID:");
        Flight flight = returnFlight(id);
        Ticket ticket = fillTicket(flight);
        Passenger passenger = fillPassenger();
        passengerInfo(passenger);
        GlobalData.passengerList.add(passenger);
        System.out.println(StatusEnum.PASSENGER_ADDED_SUCCESSFULLY);
        GlobalData.ticketList.add(ticket);
        GlobalData.airport.setTotalAmount(BigDecimal.valueOf(GlobalData.airport.getTotalAmount().doubleValue()+flight.getPrice()));
        passenger.setBalance(passenger.getBalance()-flight.getPrice());
        System.out.println(StatusEnum.TICKET_ORDER_SUCCESSFULLY);
        System.out.println("YOUR BALANCE: " + passenger.getBalance() + "AZN");
    }

    private Ticket fillTicket(Flight flight) {
        Random random = new Random();
        return new Ticket(++ticketId,random.nextInt(),flight.getSource(),flight.getDestination(),flight.getPrice(),flight.getId());
    }

    private Flight returnFlight(long id) {
        return GlobalData.flightList.stream().
                filter(flight -> flight.getId()==id)
                .findFirst()
                .orElseThrow();
    }
    @Override
    public void orderTicket() {
        byte option = orderMenu();
        try {
            switch (option){
                case 1:
                    viewFlights();
                    break;
                case 2:
                    searchHelper();
                    break;
                default: throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
            }
        }catch (ApplicationException ex){
            throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
        }
    }

    @Override
    public void cancelTicket() {
        Passenger passenger1 = null;
        List<Ticket> tickets = GlobalData.ticketList;
        long cancelId = InputUtil.getInstance().inputLong("Enter Id to delete:");

        Ticket ticket = searchTicket(cancelId, tickets);

        for (Passenger passenger: GlobalData.passengerList){
            if (passenger.getTicketId()==ticket.getId()){
                passenger1 = passenger;
            }
        }

        passenger1.setBalance(passenger1.getBalance()+ticket.getPrice());
        GlobalData.airport.setTotalAmount(BigDecimal.valueOf(GlobalData.airport.getTotalAmount().doubleValue()-ticket.getPrice()));
        System.out.println(StatusEnum.FLIGHT_SUCCESSFULLY_DELETED);
        System.out.println("Money Refunded To Your Balance " + passenger1.getBalance()+ " AZN");
    }

}
