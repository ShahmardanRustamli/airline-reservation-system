package management.impl;
import enums.ExceptionEnum;
import exceptions.ApplicationException;
import management.ManagementService;
import management.PassengerManagement;
import service.PassengerService;
import service.impl.IPassengerService;
import static util.MenuUtil.passengerMenu;

public class IPassengerManagement implements PassengerManagement {
    PassengerService passengerService = new IPassengerService();
    @Override
    public void passengerManage() {
        ManagementService managementService = new IManagementService();

        while (true) {
            try {
                byte option = passengerMenu();
                switch (option) {
                    case 0 -> {
                        System.exit(-1);
                        System.out.println("Goodbye! Have Good Day!");
                    }
                    case 1 -> managementService.management();
                    case 2 -> passengerService.viewFlights();
                    case 3 -> passengerService.orderTicket();
                    case 4 -> passengerService.cancelTicket();
                    default -> throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
                }
            }catch (ApplicationException ex){
                throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
            }


        }
    }
}
