package UTILS;

import static GL.GL.*;

public class TP {

    private String name;
    private int number;
    private ObjectiveAction action;

    public TP(int number, String name, ObjectiveAction action) {
        this.name = name;
        this.number = number;
        this.action = action;
    }

    public void run() {
        System.out.println(BOLD + CYAN + "\nStarting TP" + number + " : " + YELLOW + name + RESET);
        System.out.println();

        if (action != null) {
            System.out.println();
            action.execute();
            System.out.println();
            System.out.println();
        } else {
            System.out.println(RED + "⚠️ No action defined for this exercise." + RESET);
        }

        System.out.println(BOLD + GREEN + "\nTP" + number + " \"" + name + "\" completed!" + RESET);
        System.out.println();
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
