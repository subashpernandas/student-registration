package com.tech.subash.design.patterns.proxy;

public class CommandExecutorAccess {
    public static void main(String[] args) {
        CommandExecutorProxy commandExecutorProxy =new  CommandExecutorProxy("User", "Admin@123");
        commandExecutorProxy.runCommand("ls -la/");
    }
}
