package com.SWC.group28;

public class CurrentScoreboard implements Observer {
    public int PlayerRemainingBoats;
    public int EnemyBoatsDestroyed;

    public void update(int PlayerRemainingBoats, int EnemyBoatsDestroyed){
        this.PlayerRemainingBoats = PlayerRemainingBoats;
        this.EnemyBoatsDestroyed = EnemyBoatsDestroyed;
    }

    public void displayScoreboard() {
        System.out.println("Your scoreboard:" +
                "\n- Player remaining boats: " + PlayerRemainingBoats +
                "\n- Enemy boats destroyed: " + EnemyBoatsDestroyed);

        if (PlayerRemainingBoats == 0){
            System.out.println("Sorry, you lost!");
        }

        if (EnemyBoatsDestroyed == 10){
            System.out.println("Congratulations, you won!");
        }
    }
}
