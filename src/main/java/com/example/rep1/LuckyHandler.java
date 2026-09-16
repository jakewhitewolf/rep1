package com.example.rep1;

import javafx.scene.control.Alert;

public class LuckyHandler extends Handler {

    private final GameState game;

    public LuckyHandler(Handler processor, GameState game) {
        super(processor);
        this.game = game;
    }

    @Override
    public boolean process(Integer request) {

        if (request != ActionChain.LUCKY) {
            return super.process(request);
        }

        game.giveFreeMove();
        game.setLastEvent("Следующая попытка бесплатна");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Удача");
        alert.setHeaderText("Вы нашли безопасный тоннель. Следующая попытка бесплатна");
        alert.showAndWait();

        return true;
    }
}