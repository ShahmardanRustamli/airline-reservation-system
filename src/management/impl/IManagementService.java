package management.impl;
import enums.ExceptionEnum;
import exceptions.ApplicationException;
import management.ManagementService;
import management.PassengerManagement;
import static helper.AdminHelper.adminEntry;
import static util.MenuUtil.entryMenu;

public class IManagementService implements ManagementService {

    @Override
    public void management() {
        PassengerManagement passengerManagement = new IPassengerManagement();
        while (true){
            try {
                byte option = entryMenu();
                switch (option) {
                    case 0 -> System.exit(-1);
                    case 1 -> adminEntry();
                    case 2 -> passengerManagement.passengerManage();
                    default -> throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
                }
            }catch (ApplicationException ex){
                throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
            }
        }
    }
}
