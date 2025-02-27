package Simulacao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WarehouseGUI extends Application {
    private Simulation simulation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        simulation = new Simulation();

        Button startButton = new Button("Start Simulation");
        startButton.setOnAction(event -> runSimulation());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(startButton);

        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Warehouse Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void runSimulation() {
        new Thread(() -> {
            simulation.step1();
            for (int step = 2; step <= 136; step++) {
                switch (step) {
                    case 2 -> simulation.step2();
                    case 3 -> simulation.step3();
                    case 4 -> simulation.step4();
                    case 5 -> simulation.step5();
                    case 6 -> simulation.step6();
                    case 7 -> simulation.step7();
                    case 8 -> simulation.step8();
                    case 9 -> simulation.step9();
                    case 10 -> simulation.step10();
                    // Add more cases for step 11 to 136

                    default -> throw new IllegalArgumentException("Invalid step: " + step);
                }
                wait(320);
            }
        }).start();
    }

    /**
     * Waits for the specified number of milliseconds.
     *
     * @param milliseconds The number of milliseconds to wait.
     */
    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // ignore the exception
        }
    }

    @Override
    public void stop() {
        // Clean up resources or perform any necessary actions before the application stops
        // For example, you can stop the simulation here if needed
        Platform.exit();
    }
}
