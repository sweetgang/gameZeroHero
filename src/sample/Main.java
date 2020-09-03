package sample;

import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static sample.servaces.LabelService.fillGridByLabel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AquaFx.style();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        GridPane root = loader.load();
        Button startButton = new Button("start");

        //Create the table of game
        GridPane gameGridPane = new GridPane();
        gameGridPane.setBackground(new Background(new BackgroundFill
                (Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        gameGridPane.setHgap(5);
        gameGridPane.setVgap(5);
        fillGridByLabel(gameGridPane);

        Controller fmxlContoler =  (loader.getController());
        fmxlContoler.loadNumberHeroes(gameGridPane);
        startButton.setOnAction(event -> fmxlContoler.startGame());
        root.add(gameGridPane,0,0,1,10);
        root.add(startButton,1,0);
        primaryStage.setTitle("gameHomeworkFX");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
