package core;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button startButton = new Button("Start Game"); // Botão de Start
        StackPane root = new StackPane(startButton); // Layout
        Scene menuScene = new Scene(root, 800, 600); // Cena do Menu

        primaryStage.setTitle("Yu Yu Hakusho - GAME"); // Configurações da Janela
        primaryStage.setScene(menuScene);
        primaryStage.show();

        // Ação do Botão
        startButton.setOnAction(e -> {
            System.out.println("Iniciando o jogo...");
            Scene gameScene = createGameScene(primaryStage);
            primaryStage.setScene(gameScene);
        });
    }

    public Scene createGameScene(Stage stage) {
        Pane gamePane = new Pane();
        Scene gameScene = new Scene(gamePane, 800, 600);
        Player player = new Player(gamePane);

        gameScene.setOnKeyPressed(keyEvent -> player.handleKeyPress(keyEvent.getCode()));

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                player.update();
            }
        };
        gameLoop.start();

        return gameScene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
