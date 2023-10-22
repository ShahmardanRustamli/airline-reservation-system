package service.impl;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ApplicationException;
import globalData.GlobalData;
import management.AdminManagement;
import management.impl.IAdminManagement;
import model.Flight;
import service.AdminService;
import java.time.LocalDate;
import static helper.ServiceHelper.*;
import static util.MenuUtil.addOrBack;

public class IAdminService implements AdminService {
    @Override
    public void addFlight() {
        Flight flight = fillFlight();
            GlobalData.flightList.add(flight);
            System.out.println(StatusEnum.FLIGHT_ADDED_SUCCESSFULLY);

    }

    @Override
    public void viewTickets() {
        AdminManagement adminManagement = new IAdminManagement();
        if (GlobalData.ticketList.isEmpty()){
            try {
                System.out.println("TICKETS NOT FOUND!\nDou You Want To Add Flight?");
                byte option = addOrBack();
                switch (option){
                    case 0:
                        adminManagement.adminManage();
                        break;
                    case 1:
                        addFlight();
                        break;
                    default: throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
                }
            }catch (ApplicationException e){
                throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
            }
        } else {
            GlobalData.ticketList.
                    forEach(System.out::println);
        }

    }

    @Override
    public void viewPassenger() {
        if (GlobalData.passengerList.isEmpty()){
            throw new ApplicationException(ExceptionEnum.PASSENGER_NOT_FOUND_EXCEPTION);
        }
        GlobalData.passengerList.stream()
                .forEach(System.out::println);
    }

    @Override
    public void viewNoticeBoard() {
        if (GlobalData.flightList.isEmpty()){
            throw new ApplicationException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        }
        GlobalData.flightList.stream()
                .filter(flight -> flight.getDate().getDayOfMonth()== LocalDate.now().getDayOfMonth()).
                forEach(System.out::println);

    }

    @Override
    public void viewFlight() {
        showFlights();
    }

    @Override
    public void searchAll() {
        searchHelper();
    }
}
