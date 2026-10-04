public class Main {

    public static void main(String[] args) {

        // Create the old legacy firewall
        LegacyFirewall legacyFirewall = new LegacyFirewall();

        // Adapt it so the modern system can use SecurityLog
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        // Use the modern SecurityLog methods
        securityLog.logEvent("Unauthorized login attempt detected.");
        securityLog.setSeverity(3);
    }
}