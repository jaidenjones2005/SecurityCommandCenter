import java.util.List;

public class UserAccessManager {

    public void lockUserAccounts(List<String> usernames) {
        for (String username : usernames) {
            System.out.println("UserAccessManager: Locking account " + username);
        }
    }

    public void unlockUserAccounts(List<String> usernames) {
        for (String username : usernames) {
            System.out.println("UserAccessManager: Unlocking account " + username);
        }
    }

    public void grantAdminAccess(String user) {
        System.out.println("UserAccessManager: Granting admin access to " + user);
    }
}