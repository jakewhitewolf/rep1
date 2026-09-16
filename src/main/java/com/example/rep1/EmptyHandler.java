package com.example.rep1;

import javafx.scene.control.Alert;

public class EmptyHandler extends Handler {

    private final GameState game;

    public EmptyHandler(Handler processor, GameState game) {
        super(processor);
        this.game = game;
    }

    @Override
    public boolean process(Integer request) {

        if (request != ActionChain.EMPTY) {
            return super.process(request);
        }

        game.setLastEvent("Шахта оказалась пустой");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Пусто");
        alert.setHeaderText("В этот раз ничего найти не удалось");
        alert.showAndWait();

        return true;
    }
}