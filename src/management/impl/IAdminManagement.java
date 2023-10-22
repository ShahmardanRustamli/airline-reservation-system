package management.impl;
import enums.ExceptionEnum;
import exceptions.ApplicationException;
import management.AdminManagement;
import management.ManagementService;
import service.AdminService;
import service.impl.IAdminService;
import util.MenuUtil;
public class IAdminManagement implements AdminManagement {
    @Override
    public void adminManage() {
        ManagementService managementService = new IManagementService();
        AdminService adminService = new IAdminService();
        while (true){
            try {
                int option = MenuUtil.adminMenu();
                switch (option) {
                    case 0 -> System.exit(-1);
                    case 1 -> managementService.management();
                    case 2 -> adminService.addFlight();
                    case 3 -> adminService.viewTickets();
                    case 4 -> adminService.viewPassenger();
                    case 5 -> adminService.viewNoticeBoard();
                    case 6 -> adminService.viewFlight();
                    case 7 -> adminService.searchAll();
                    default -> throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
                }
            }catch (ApplicationException ex){
                throw new ApplicationException(ExceptionEnum.INVALID_CHOICE_EXCEPTION);
            }
        }
    }
}
