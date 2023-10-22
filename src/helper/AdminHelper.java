package helper;
import enums.ExceptionEnum;
import management.AdminManagement;
import management.impl.IAdminManagement;
import util.InputUtil;

public class AdminHelper {
    static AdminManagement adminManagement = new IAdminManagement();
    public static void adminEntry(){
        final String ADMIN_USERNAME = "admin";
        final String ADMIN_PASS = "admin";
        final byte MAX_ATTEMPTS = 3;
        byte attempt = 0;
        byte LAST_ATTEMPTS =3;
        System.out.println("------------| ADMIN LOGIN |-----------");
        while (attempt<MAX_ATTEMPTS){
            String username = InputUtil.getInstance().inputString("Enter Admin Username:");
            String password = InputUtil.getInstance().inputString("Enter Admin Password:");
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASS)) {
                adminManagement.adminManage();
            } else {
                System.out.println(ExceptionEnum.INVALID_LOGIN_EXCEPTION);
                System.out.println("Incorrect Password or Username, Please Try Again!\n" +
                        "Your attempts: " + --LAST_ATTEMPTS);
                attempt++;
            }
            if (attempt == MAX_ATTEMPTS){
                System.out.println("Limit Reached! System is Closing...");
                Runtime.getRuntime().exit(0);
            }
        }
    }
}
