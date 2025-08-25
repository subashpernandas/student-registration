package com.tech.subash.lombok;


public class NormalUser  {
    public static void main(String[] args) {
        User user = new User("subahs",31);
        System.out.println(user.getAge() + " "+ user.getName());
        User user1 = user.withAge(23).withName("subash pernandas");
        System.out.println(user1.getAge() + user1.getName());
    }
}
