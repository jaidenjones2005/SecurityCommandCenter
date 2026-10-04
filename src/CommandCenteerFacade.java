import java.util.Arrays;
import java.util.List;

public class CommandCenterFacade {

    private NetworkTrafficController network;
    private UserAccessManager accessManager;
    private EncryptionService encryption;

    private final List<String> compromisedUsers = Arrays.asList(
            "admin_temp",
            "guest_user_1",
            "service_acct"
    );

    private final String databaseName = "Customer_Records";

    public CommandCenterFacade(
            NetworkTrafficController network,
            UserAccessManager accessManager,
            EncryptionService encryption) {

        this.network = network;
        this.accessManager = accessManager;
        this.encryption = encryption;
    }

    public void initiateEmergencyLockdown() {
        System.out.println("\n--- EMERGENCY LOCKDOWN ---");

        network.blockPort(8080);
        network.blockPort(443);
        accessManager.lockUserAccounts(compromisedUsers);
        encryption.encryptDatabase(databaseName);
        network.divertTraffic();
    }

    public void liftEmergencyLockdown() {
        System.out.println("\n--- LIFTING EMERGENCY LOCKDOWN ---");

        network.unblockPort(8080);
        network.unblockPort(443);
        accessManager.unlockUserAccounts(compromisedUsers);
        encryption.decryptDatabase(databaseName);
    }

    public void enableMaintenanceMode() {
        System.out.println("\n--- MAINTENANCE MODE ---");

        network.divertTraffic();
        accessManager.grantAdminAccess("system_admin");
        encryption.verifyIntegrity();
    }
}