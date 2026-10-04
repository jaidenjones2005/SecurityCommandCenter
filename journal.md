# Phase 1 - Adapter Pattern

The Adapter pattern helps follow the Principle of Least Knowledge because the main dashboard only needs to know about the SecurityLog interface. It does not need to understand how the LegacyFirewall works or know its different method names.

This is better because the FirewallAdapter handles the translation between the modern SecurityLog methods and the older LegacyFirewall methods. This keeps the main program simpler and reduces coupling between different parts of the system.