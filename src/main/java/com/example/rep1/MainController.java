package com.example.rep1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label moneyLabel;

    @FXML
    private Label lootLabel;

    @FXML
    private Label eventLabel;

    private GameState game;
    private ActionChain actionChain;

    @FXML
    public void initialize() {
        game = new GameState();
        actionChain = new ActionChain(game);

        updateInterface();
    }

    @FXML
    private void onOldMine() {
        play(1);
    }

    @FXML
    private void onDeepMine() {
        play(2);
    }

    @FXML
    private void onAbandonedMine() {
        play(3);
    }

    private void play(int mine) {

        if (!game.pay()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Недостаточно средств");
            alert.setHeaderText("У вас закончились монеты!");
            alert.setContentText("Продолжить игру невозможно.");
            alert.showAndWait();

            eventLabel.setText("Недостаточно монет");

            return;
        }

        actionChain.process(mine);

        updateInterface();
    }

    @FXML
    private void onTakeLoot() {

        if (game.getLoot() <= 0) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Нет добычи");
            alert.setHeaderText("Сейчас вам нечего забирать.");
            alert.showAndWait();

            return;
        }

        int loot = game.getLoot();

        game.takeLoot();

        eventLabel.setText(
                "Вы забрали добычу: +" + loot + " монет"
        );

        updateInterface();
    }

    private void updateInterface() {
        moneyLabel.setText(
                "Баланс: " + game.getMoney()
        );

        lootLabel.setText(
                "Добыча: " + game.getLoot()
        );

        eventLabel.setText(
                game.getLastEvent()
        );
    }
}