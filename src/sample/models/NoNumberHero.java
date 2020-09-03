package sample.models;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class NoNumberHero extends NumberHero {

    public NoNumberHero() {
        this.setColor(new Background(new BackgroundFill
                (Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void setHeroProperties(Label label) {
        super.setHeroProperties(label);
        label.setText("Eror");
    }
}
