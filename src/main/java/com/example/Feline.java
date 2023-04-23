package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    private final Animal animal;

    public Feline(Animal animal) {
        this.animal = animal;
    }
    @Override
    public List<String> eatMeat() throws Exception {
        return animal.getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
