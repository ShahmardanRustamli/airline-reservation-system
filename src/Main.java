import management.impl.IManagementService;
import management.ManagementService;


public class Main {
    public static void main(String[] args) {
        ManagementService managementService = new IManagementService();
        managementService.management();
    }
}
