# Phase 1 - Adapter Pattern

The Adapter pattern helps follow the Principle of Least Knowledge because the main dashboard only needs to know about the SecurityLog interface. It does not need to understand how the LegacyFirewall works or know its different method names.

This is better because the FirewallAdapter handles the translation between the modern SecurityLog methods and the older LegacyFirewall methods. This keeps the main program simpler and reduces coupling between different parts of the system.

# Phase 2 - Subsystem Setup & Direct Interaction

For the All-Clear sequence, I had to keep track of the same ports, users, and database that were affected during the emergency. I used a list to keep track of the compromised users and manually called the methods needed to unblock the ports, unlock the accounts, and decrypt the database.

This manual approach could become dangerous if the system grew to handle thousands of ports and users. It would be easy to forget an action, restore the wrong resource, or make a mistake when reversing the emergency. Managing all of these individual subsystem calls directly would also make the Main class difficult to maintain.

# Phase 3 - Facade Pattern & Integration

The Facade pattern makes the Main class much simpler compared to Phase 2. Instead of Main having to manually call every subsystem method and remember which ports, users, and database need to be restored, it can call one high-level method such as initiateEmergencyLockdown() or liftEmergencyLockdown().

This also makes the All-Clear process safer because the CommandCenterFacade contains the steps needed to reverse the lockdown. If the NetworkTrafficController was replaced with a different vendor's version, Main should not need to change as long as the CommandCenterFacade handles the differences. This keeps the client code separated from the details of the subsystem.