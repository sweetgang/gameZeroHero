package sample.servaces;


import sample.models.NumberHero;

import java.util.ArrayList;
import java.util.List;

public class NumberHeroService {

    private static List<int[]> positionHeroes = new ArrayList<>();

    public static List<int[]> inicilizationPositionHeroes() {
        if (positionHeroes.size() >= 30) return positionHeroes;
        for (int i = 0; i < 30; i++) {
            addPositionHero();
        }
        return positionHeroes;
    }

    private static void addPositionHero(){
        int[] newPosition = new int[]{(int) (Math.random() * 10), (int) (Math.random() * 10)};
        if (positionHeroes.size() == 0) {
            positionHeroes.add(newPosition);
        }else checkPositionHero(newPosition);
    }

    private static void checkPositionHero(int[] newPosition){
        boolean agreeAdd = true;
        for (int j = 0; j < positionHeroes.size(); j++) {
            if ( positionHeroes.get(j)[0] == newPosition[0]
                    && positionHeroes.get(j)[1] == newPosition[1]){
                addPositionHero();
                agreeAdd = false;
            }
        }
        if (agreeAdd) positionHeroes.add(newPosition);
    }

    public static  int[] newZeroHeroPosition(NumberHero numberHero){
        int[] addStep = choseStep();
        int[] newPosition = new int[]{ numberHero.getPositionX() + addStep[0],
                numberHero.getPositionY() + addStep[1]};
        if (newPosition[0] > 9 || newPosition[0] < 0 ||
                newPosition[1] > 9 || newPosition[1] < 0) {
            newPosition = newZeroHeroPosition(numberHero);
        }
        return newPosition;
    }

    public static int[] choseStep(){
        int[] step = new int[]{-1, 1, 0 };
        int positionX = (int) (Math.random()*3);
        int positionY;
        if (positionX != 2) positionY = 2;
        else positionY = (int) (Math.random()*2);
        int newStep[] = {step[positionX],step[positionY]};
        return newStep;
    }
}
