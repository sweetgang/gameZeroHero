package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import sample.models.NumberHero;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;
import static sample.controllers.NumberHeroController.*;
import static sample.servaces.LabelService.getLabelById;

public class Controller implements Initializable {
    //Create numberHero and take them to list
    private static  ObservableList<NumberHero> numberHeroObservableList =
            FXCollections.observableArrayList(createNumberHero());

    // Take number, color and place numberHero to suit label
    public void loadNumberHeroes(GridPane gameGridPane) {
        for (int i = 0; i < numberHeroObservableList.size(); i++) {
            numberHeroObservableList.get(i).
                    setHeroProperties(getLabelById(numberHeroObservableList.get(i).setIdForLabel()));
        }
    }

    public void startGame() {
        for (int i = 0; i < numberHeroObservableList.size(); i++) {
            if (numberHeroObservableList.get(i).getNumber() == 0) {
                int finalI = i;
                Thread zeroHeroThread = numberHeroObservableList.get(i).getHeroThread();
                zeroHeroThread.start();

            }
        }
    }

    public static ObservableList<NumberHero> getNumberHeroObservableList() {
        return numberHeroObservableList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
