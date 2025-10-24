package TP1.EX5.base;

public class Bird extends Animal implements IWalk {
    public float wingSpan;

    @Override
    public void Eat() {
        System.out.println("\t\tThe bird pecks gently at seeds and grains.");
    }

    @Override
    public void Sleep() {
        System.out.println("\t\tThe bird sleeps peacefully in its nest high above the trees.");
    }

    @Override
    public void Walk() {
        System.out.println("\t\tThe bird hops lightly on its two legs.");
    }
}
