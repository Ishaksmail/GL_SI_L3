package TP1;

import UTILS.EX;
import UTILS.EXEC;
import UTILS.TP;

public class Exec implements EXEC {

    @Override
    public void run() {
        TP tp1 = new TP(1, "Object-Oriented Programming");

        tp1.addExercise(new EX(1, "Encapsulation", () -> {
            // TP1 Ex01
            TP1.EX1.Exec exec = new TP1.EX1.Exec();
            exec.run();
        }));

        tp1.addExercise(new EX(2, "Inheritance", () -> {
            // TP1 Ex02

            TP1.EX2.Exec exec = new TP1.EX2.Exec();
            exec.run();

        }));

        tp1.addExercise(new EX(3, "Polymorphism", () -> {
            // TP1 EX03
            TP1.EX3.Exec exec = new TP1.EX3.Exec();
            exec.run();
        }));

        tp1.addExercise(new EX(4, "Abstraction", () -> {
            // TP EX04
            TP1.EX4.Exec exec = new TP1.EX4.Exec();
            exec.run();
        }));

        tp1.addExercise(new EX(5, "All Testing", () -> {
            // TP EX05
            TP1.EX5.Exec exec = new TP1.EX5.Exec();
            exec.run();

        }));

        // تنفيذ جميع التمارين
        tp1.run();
    }

}
