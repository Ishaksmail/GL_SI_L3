package TP1.EX5.base;

import java.awt.Color;

public class Mammal extends Animal implements IWalk {

    public Color furColor;

    @Override
    public void Eat() {
        System.out.println("\t\tThe mammal chews its food carefully using strong jaws.");
    }

    @Override
    public void Sleep() {
        System.out.println("\t\tThe mammal rests in a warm and safe place to regain its energy.");
    }

    @Override
    public void Walk() {
        System.out.println("\t\tThe mammal walks steadily on four legs.");
    }
}
