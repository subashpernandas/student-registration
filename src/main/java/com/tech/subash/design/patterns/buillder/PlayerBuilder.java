package com.tech.subash.design.patterns.buillder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerBuilder {

    private String name;
    private int age;
    private String gameName;

    private List<String> extraCurricularActivities;

    public PlayerBuilder(String name, int age, String gameName) {
        this.age = age;
        this.name = name;
        this.gameName = gameName;
    }

    public PlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public PlayerBuilder setExtraCurricularActivities(List<String> extraCurricularActivities) {
        this.extraCurricularActivities = extraCurricularActivities;
        return this;
    }

    public PlayerDetails buildPlayer() {
        return new PlayerDetails(this);
    }

    public static void main(String[] args) {
        PlayerDetails player = new PlayerBuilder("subash pernandas", 33, "Foot Ball").buildPlayer();
        System.out.println(player);

        PlayerDetails player2 = new PlayerBuilder("subash pernandas", 33, "Foot Ball")
                .setExtraCurricularActivities(List.of("Karate", "Judo"))
                .buildPlayer();
        System.out.println(player2);
    }

}
