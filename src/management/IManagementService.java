package management;
import enums.ExceptionEnum;
import exceptions.ApplicationException;
import static helper.AdminHelper.adminEntry;
import static util.MenuUtil.entryMenu;

public class IManagementService implements ManagementService {
    PassengerManagement passengerManagement = new IPassengerManagement();
    @Override
    public void management() {
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
