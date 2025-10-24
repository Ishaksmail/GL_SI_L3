package TP1;
import UTILS.EXEC;
import UTILS.TP;

public class Exec implements EXEC {

    @Override
    public void run() {

        TP tp1 = new TP(1, "Object-Oriented Programming", () -> {

            // TP1 Ex01
            TP1.EX1.Exec ex1_exec = new TP1.EX1.Exec();
            ex1_exec.run();

            // TP1 Ex02
            TP1.EX2.Exec ex2_exec = new TP1.EX2.Exec();
            ex2_exec.run();

            // TP1 EX03
            TP1.EX3.Exec ex3_exec = new TP1.EX3.Exec();
            ex3_exec.run();

            // TP EX04
            TP1.EX4.Exec ex4_exec = new TP1.EX4.Exec();
            ex4_exec.run();

            // TP EX05
            TP1.EX5.Exec ex5_exec = new TP1.EX5.Exec();
            ex5_exec.run();

        });

        // تنفيذ جميع التمارين
        tp1.run();
    }

}
