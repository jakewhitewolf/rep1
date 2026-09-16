package com.example.rep1;

import javafx.scene.control.Alert;

public class GemHandler extends Handler {

    private final GameState game;

    public GemHandler(Handler processor, GameState game) {
        super(processor);
        this.game = game;
    }

    @Override
    public boolean process(Integer request) {

        if (request != ActionChain.GEM) {
            return super.process(request);
        }

        int reward = 5;

        game.addLoot(reward);
        game.setLastEvent("Найден самоцвет: +" + reward + " монет");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Самоцвет");
        alert.setHeaderText("Вы нашли самоцвет стоимостью " + reward + " монет");
        alert.showAndWait();

        return true;
    }
}