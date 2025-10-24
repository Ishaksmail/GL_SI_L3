package UTILS;

import java.util.ArrayList;
import java.util.List;

import static GL.GL.*;

public class TP {

    private String name;
    private int number;
    private List<EX> exercises = new ArrayList<>();

    public TP(int number,String name) {
        this.name = name;
        this.number = number;
    }

    public void addExercise(EX ex) {
        exercises.add(ex);
    }

    public void run() {
        System.out.println(BOLD + CYAN + "\nStarting TP"+number+" : " + YELLOW + name + RESET);
        System.out.println();
            
        if (exercises.isEmpty()) {
            System.out.println("⚠️ No exercises found.");
            return;
        }

        for (EX ex : exercises) {
            ex.run();
        }

        System.out.println(BOLD + GREEN + "\nTP"+number+" \"" + name + "\" completed!" + RESET);
        System.out.println();
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public List<EX> getExercises() {
        return exercises;
    }

    public void setExercises(List<EX> exercises) {
        this.exercises = exercises;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
