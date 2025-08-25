package com.tech.subash.design.patterns.buillder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerDetails {
    private String name;
    private int age;
    private String gameName;

    private List<String> extraCurricularActivities;

    public PlayerDetails(PlayerBuilder playerBuilder) {
        this.age = playerBuilder.getAge();
        this.name = playerBuilder.getName();
        this.gameName = playerBuilder.getGameName();
        this.extraCurricularActivities = playerBuilder.getExtraCurricularActivities();
    }
    // Getter Only

    /*public Player setName(String name) {
        this.name = name;
        return  this;
    }

    public Player setAge(int age) {
        this.age = age;
        return this;
    }

    public Player setGameName(String gameName) {
        this.gameName = gameName;
        return  this;
    }

    public Player setExtraCurricularActivities(List<String> extraCurricularActivities) {
        this.extraCurricularActivities = extraCurricularActivities;
        return this;
    }


    public static void main(String[] args) {
        Player player = new Player().setAge(21).setName("subash").setGameName("football");
        System.out.println(player);

        Player player2 = new Player().setName("subash").setGameName("football");
        System.out.println(player2);

    }*/
}
