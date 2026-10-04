import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Phase 1 - Adapter Pattern
        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        securityLog.logEvent("Unauthorized login attempt detected.");
        securityLog.setSeverity(3);

        // Phase 2 - Create subsystem objects
        NetworkTrafficController network = new NetworkTrafficController();
        UserAccessManager accessManager = new UserAccessManager();
        EncryptionService encryption = new EncryptionService();

        List<String> compromisedUsers = Arrays.asList(
                "admin_temp",
                "guest_user_1",
                "service_acct"
        );

        // Emergency Breach
        System.out.println("\n--- EMERGENCY BREACH ---");

        network.blockPort(8080);
        network.blockPort(443);
        accessManager.lockUserAccounts(compromisedUsers);
        encryption.encryptDatabase("Customer_Records");
        network.divertTraffic();

        // All-Clear
        System.out.println("\n--- ALL-CLEAR ---");

        network.unblockPort(8080);
        network.unblockPort(443);
        accessManager.unlockUserAccounts(compromisedUsers);
        encryption.decryptDatabase("Customer_Records");
    }
}