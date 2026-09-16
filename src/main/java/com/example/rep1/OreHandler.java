package com.example.rep1;

import javafx.scene.control.Alert;

import java.util.Random;

public class OreHandler extends Handler {

    private final GameState game;
    private final Random random = new Random();

    public OreHandler(Handler processor, GameState game) {
        super(processor);
        this.game = game;
    }

    @Override
    public boolean process(Integer request) {

        if (request != ActionChain.ORE) {
            return super.process(request);
        }

        int reward = 1 + random.nextInt(3);

        game.addLoot(reward);
        game.setLastEvent("Найдена руда: +" + reward + " монет");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Найдена руда");
        alert.setHeaderText("Вы нашли руду стоимостью " + reward + " монет");
        alert.showAndWait();

        return true;
    }
}