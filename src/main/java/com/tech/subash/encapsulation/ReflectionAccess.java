package com.tech.subash.encapsulation;

import java.lang.reflect.Field;

public class ReflectionAccess {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Account account = new Account();
        account.setBalance(100);
        Field field = Account.class.getDeclaredField("balance");
        field.setAccessible(true);
        field.set(account, 200);
        System.out.println(field.get(account) + " "+ account.getBalance()); // 200.0  200.0
    }
}
