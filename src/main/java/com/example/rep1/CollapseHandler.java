package com.example.rep1;

import javafx.scene.control.Alert;

public class CollapseHandler extends Handler {

    private final GameState game;

    public CollapseHandler(Handler processor, GameState game) {
        super(processor);
        this.game = game;
    }

    @Override
    public boolean process(Integer request) {

        if (request != ActionChain.COLLAPSE) {
            return super.process(request);
        }

        game.loseLoot();
        game.setLastEvent("Произошёл обвал. Добыча потеряна");

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Обвал");
        alert.setHeaderText("Вся добыча текущей экспедиции потеряна");
        alert.showAndWait();

        return false;
    }
}