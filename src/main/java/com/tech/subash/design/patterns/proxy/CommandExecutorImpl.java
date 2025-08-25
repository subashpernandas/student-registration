package com.tech.subash.design.patterns.proxy;

public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(String command) {
        System.out.println("command run "+ command);
    }
}
