package sample.models;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static java.lang.Thread.sleep;
import static sample.Controller.getNumberHeroObservableList;
import static sample.controllers.NumberHeroController.moveZeroHero;
import static sample.servaces.LabelService.getHeroFromLabel;
import static sample.servaces.LabelService.getLabelById;

public class NumberHero {
    private String name;
    private int number;
    private int positionX;
    private int positionY;
    private int previousPositionX;
    private int previousPositionY;
    private boolean isAlive = true;
    private Background color;

    public void setHeroProperties(Label label) {
        label.setFont(Font.font("Cambria", 40));
        label.setPrefWidth(50);
        label.setAlignment(Pos.CENTER);
        label.setText("" + number);
        if (number == 0) label.setBackground(new Background(new BackgroundFill
                (Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
        else label.setBackground(new Background(new BackgroundFill
                (Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    // We check if a zero hero is playing and he attacked another hero
    // with a composite number  just add 1 to the number, otherwise the another
    // hero is dead, and when the hero is not attacked  leave a blank space
    public void unSetHeroProperties(Label label) {
        label.setText("");
        label.setBackground(new Background(new BackgroundFill
                (Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        if ( number == 0 ) {
            unSetZeroHero();
        }
    }

    private void unSetZeroHero() {
        if (!getLabelById("label" + positionX + positionY).getText().equals("")) {
            NumberHero combatedHero = getHeroFromLabel("label" + positionX + positionY);
            if (isHeroCompositNumber(combatedHero.getNumber())){
                combatedHero.setNumber(combatedHero.getNumber() + 1);
                combatedHero.setPreviousPositionX(positionX);
                combatedHero.setPreviousPositionY(positionY);
                combatedHero.setPositionX(previousPositionX);
                combatedHero.setPositionY(previousPositionY);
                combatedHero.setHeroProperties(getLabelById("label" + previousPositionX
                        + previousPositionY));
            }else {
                combatedHero.isAlive = false;
            }
        }
    }

    private boolean isHeroCompositNumber(int heroNumber){
        boolean result = false;
        for (int i = 2 ; i < heroNumber; i++ ){
            if (heroNumber % i == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Thread getHeroThread() {
        return new Thread(() -> {
            while (this.isAlive) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    previousPositionX = positionX;
                    previousPositionY = positionY;
                    moveZeroHero(this);
                    this.unSetHeroProperties(getLabelById("label" +
                            previousPositionX + previousPositionY));
                    this.setHeroProperties(getLabelById("label" + positionX + positionY));
                });


            }
        });
    }

    public String setIdForLabel() {
        return "label" + positionX + positionY;
    }

    // Getters and setters block
    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean status) {
        this.isAlive = status;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPreviousPositionX() {
        return previousPositionX;
    }

    public void setPreviousPositionX(int previousPositionX) {
        this.previousPositionX = previousPositionX;
    }

    public int getPreviousPositionY() {
        return previousPositionY;
    }

    public void setPreviousPositionY(int previousPositionY) {
        this.previousPositionY = previousPositionY;
    }

    public Background getColor() {
        return color;
    }

    public void setColor(Background color) {
        this.color = color;
    }
}
