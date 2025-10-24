package TP1.EX2;

import static GL.GL.BLUE;
import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

import TP1.EX2.base.Eagle;
import TP1.EX2.base.Penguin;
import TP1.EX2.base.Sparrow;
import UTILS.EX;
import UTILS.EXEC;

public class Exec implements EXEC {

        @Override
        public void run() {

                EX ex = new EX(2, "Inheritance", () -> {

                        System.out.println();
                        System.out.println(CYAN + "\t\tInheritance Example:" + RESET);
                        System.out.println("\t\tWe have defined three bird types: Eagle, Penguin, and Sparrow.");
                        System.out.println("\t\tAll inherit from the base class 'Bird'.");
                        System.out.println();

                        Eagle eagle = new Eagle();
                        System.out.println(BLUE + "\t\t> Eagle:" + RESET);
                        eagle.eat();
                        eagle.fly();
                        Penguin penguin = new Penguin();
                        System.out.println(BLUE + "\t\t> Penguin:" + RESET);
                        penguin.eat();
                        penguin.swim();
                        Sparrow sparrow = new Sparrow();
                        System.out.println(BLUE + "\t\t> Sparrow:" + RESET);
                        sparrow.eat();
                        sparrow.fly();
                        System.out.println();
                        System.out
                                        .println(GREEN + "\t\tCommon behavior:" + RESET + " All birds can " + YELLOW
                                                        + "eat()" + RESET
                                                        + ".");
                        System.out.println(GREEN + "\t\tSpecialized behavior:" + RESET + " Some can " + YELLOW + "fly()"
                                        + RESET
                                        + ", while others can " + YELLOW + "swim()" + RESET + ".");
                        System.out.println(MAGENTA
                                        + "\t\tInheritance allows sharing and extending behavior efficiently." + RESET);
                });

                System.out.println();
                System.out.println();
                System.out.println();
                ex.run();

        }

}
