# Phase 1 - Adapter Pattern

The Adapter pattern helps follow the Principle of Least Knowledge because the main dashboard only needs to know about the SecurityLog interface. It does not need to understand how the LegacyFirewall works or know its different method names.

This is better because the FirewallAdapter handles the translation between the modern SecurityLog methods and the older LegacyFirewall methods. This keeps the main program simpler and reduces coupling between different parts of the system.

# Phase 2 - Subsystem Setup & Direct Interaction

For the All-Clear sequence, I had to keep track of the same ports, users, and database that were affected during the emergency. I used a list to keep track of the compromised users and manually called the methods needed to unblock the ports, unlock the accounts, and decrypt the database.

This manual approach could become dangerous if the system grew to handle thousands of ports and users. It would be easy to forget an action, restore the wrong resource, or make a mistake when reversing the emergency. Managing all of these individual subsystem calls directly would also make the Main class difficult to maintain.