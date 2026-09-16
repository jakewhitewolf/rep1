package com.example.rep1;

public class GameState {

    private int money = 10;
    private int loot = 0;
    private boolean freeMove = false;

    private String lastEvent = "Экспедиция ещё не началась";

    public boolean pay() {

        if (freeMove) {
            freeMove = false;
            return true;
        }

        if (money <= 0) {
            return false;
        }

        money--;

        return true;
    }

    public void addLoot(int amount) {
        loot += amount;
    }

    public void takeLoot() {
        money += loot;
        loot = 0;
    }

    public void loseLoot() {
        loot = 0;
    }

    public void giveFreeMove() {
        freeMove = true;
    }

    public int getMoney() {
        return money;
    }

    public int getLoot() {
        return loot;
    }

    public boolean isFreeMove() {
        return freeMove;
    }

    public String getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(String lastEvent) {
        this.lastEvent = lastEvent;
    }
}
