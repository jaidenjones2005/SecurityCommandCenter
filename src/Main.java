import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Adapter Pattern setup
        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        System.out.print("Enter a security event message: ");
        String message = scanner.nextLine();

        System.out.print("Enter severity level: ");
        int severity = scanner.nextInt();
        scanner.nextLine();

        securityLog.logEvent(message);
        securityLog.setSeverity(severity);

        // Facade Pattern setup
        NetworkTrafficController network = new NetworkTrafficController();
        UserAccessManager accessManager = new UserAccessManager();
        EncryptionService encryption = new EncryptionService();

        CommandCenterFacade commandCenter =
                new CommandCenterFacade(network, accessManager, encryption);

        // User chooses security mode
        System.out.println("\nChoose a security mode:");
        System.out.println("1. Lockdown");
        System.out.println("2. Lift Lockdown");
        System.out.println("3. Maintenance");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                commandCenter.initiateEmergencyLockdown();
                break;

            case 2:
                commandCenter.liftEmergencyLockdown();
                break;

            case 3:
                commandCenter.enableMaintenanceMode();
                break;

            default:
                System.out.println("Invalid security mode.");
        }

        scanner.close();
    }
}