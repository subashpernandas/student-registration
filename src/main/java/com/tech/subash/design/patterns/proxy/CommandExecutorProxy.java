package com.tech.subash.design.patterns.proxy;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(String userName, String password) {
        if ("Admin".equalsIgnoreCase(userName) && "Admin@123".equals(password)) {
            isAdmin = true;
        }
        //  commandExecutor = new CommandExecutorImpl();// Eager Initialization
    }

    @Override
    public void runCommand(String command) {
        commandExecutor = commandExecutor == null ? new CommandExecutorImpl() : commandExecutor;
        // Lazy initialization
        if (isAdmin) {
            commandExecutor.runCommand(command);
        } else {
            if (command.startsWith("rm")) {
                throw new RuntimeException("Command not allowed for this user role ");
            } else {
                commandExecutor.runCommand(command);
            }
        }
    }
}
