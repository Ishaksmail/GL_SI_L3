package UTILS;

import static GL.GL.*;



public class EX {
    private int number;
    private String objective;
    private ObjectiveAction action;

    public EX(int number, String objective, ObjectiveAction action) {
        this.number = number;
        this.objective = objective;
        this.action = action;
    }

    public void run() {
        System.out.print(BOLD + "\tExercise " + number + " : " + RESET);
        System.out.print(" " + objective);

        if (action != null) {
            System.out.println();
            action.execute();
            System.out.println();
            System.out.println();
        } else {
            System.out.println(RED + "⚠️ No action defined for this exercise." + RESET);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAction(ObjectiveAction action) {
        this.action = action;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }
}
