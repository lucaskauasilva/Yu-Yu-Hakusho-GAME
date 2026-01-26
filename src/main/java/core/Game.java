package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Botão de Start
        Button startButton = new Button("Start Game");

        // Ação do Botão
        startButton.setOnAction(e -> {
            System.out.println("Iniciando o jogo...");
            // Aqui depois vamos trocar para a cena do jogo
        });

        // Layout
        StackPane root = new StackPane();
        root.getChildren().add(startButton);

        // Cena
        Scene scene = new Scene(root, 800, 600);

        // Configuração da janela
        primaryStage.setTitle("Yu Yu Hakusho - GAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
