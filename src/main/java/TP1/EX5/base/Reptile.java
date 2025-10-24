package TP1.EX5.base;

public class Reptile extends Animal {

    public float scaleType;

    @Override
    public void Eat() {
        System.out.println("\t\tThe reptile flicks its tongue and slowly swallows its prey.");
    }

    @Override
    public void Sleep() {
        System.out.println("\t\tThe reptile rests under a warm rock to absorb heat and regain energy.");
    }
}
