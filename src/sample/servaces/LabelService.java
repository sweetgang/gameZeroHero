package sample.servaces;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sample.models.NoNumberHero;
import sample.models.NumberHero;

import java.util.ArrayList;
import java.util.List;

import static sample.Controller.getNumberHeroObservableList;

public class LabelService {
    private static List<Label> labelList = new ArrayList<>();

    //Create and  fill our gameGridPane by empty label size 10*10
    public static void fillGridByLabel(GridPane gameGridPane){
        for (int i = 0; i < 10; i++ ) {
            for (int j = 0; j < 10; j++ ){
                Label label = new Label();
                label.setId("label"+i+j);
                label.setMinSize(50.0,50.0);
                label.setBackground(new Background(new BackgroundFill
                        (Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                setLabelToList(label);
                gameGridPane.add(label,i,j);
            }
        }
    }

   public static Label getLabelById(String nameId){
       for (int i = 0; i <labelList.size() ; i++) {
           if (labelList.get(i).getId().equals(nameId)) return labelList.get(i);
       }
       return null;
   }

    public static NumberHero getHeroFromLabel(String labelId){
        NumberHero result = new NoNumberHero();
        for (int i = 0; i < getNumberHeroObservableList().size() ; i++) {
            if (labelId.equals("label" + getNumberHeroObservableList().get(i).getPositionX()
                    + getNumberHeroObservableList().get(i).getPositionY())){
                result = getNumberHeroObservableList().get(i);
            };
        }
        return result;
    }

    public static void setLabelToList(Label label) {
        LabelService.labelList.add(label);
    }
}
