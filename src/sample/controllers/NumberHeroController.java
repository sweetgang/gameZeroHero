package sample.controllers;

import sample.models.NumberHero;
import sample.servaces.NumberHeroService;

import java.util.ArrayList;
import java.util.List;

import static sample.servaces.NumberHeroService.newZeroHeroPosition;

public class NumberHeroController {

  public static List<NumberHero> createNumberHero(){
    List<NumberHero> numberHeroList = new ArrayList<>();
    NumberHero zeroHero = new NumberHero();
    zeroHero.setNumber(0);
    zeroHero.setPositionX(NumberHeroService.inicilizationPositionHeroes().get(0)[0]);
    zeroHero.setPositionY(NumberHeroService.inicilizationPositionHeroes().get(0)[1]);
    zeroHero.setName("Zero_hero");
    numberHeroList.add(zeroHero);
    for (int i = 1; i < 30; i++) {
      NumberHero numberHero = new NumberHero();
      numberHero.setNumber((int) (Math.random() * 99)+1);
      numberHero.setName("Hero_" + numberHero.getNumber());
      numberHero.setPositionX(NumberHeroService.inicilizationPositionHeroes().get(i)[0]);
      numberHero.setPositionY(NumberHeroService.inicilizationPositionHeroes().get(i)[1]);
      numberHeroList.add(numberHero);
    }
    return numberHeroList;
  }



  public static void moveZeroHero(NumberHero numberHero){
    int[] newPosition = newZeroHeroPosition(numberHero);
    numberHero.setPositionX(newPosition[0]);
    numberHero.setPositionY(newPosition[1]);
  }

  public static  void moveNumberHero(NumberHero numberHero){
    int[] newPosition = newZeroHeroPosition(numberHero);
    numberHero.setPositionX(newPosition[0]);
    numberHero.setPositionY(newPosition[1]);
  }

}
