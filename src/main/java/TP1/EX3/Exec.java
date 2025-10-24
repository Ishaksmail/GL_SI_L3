package TP1.EX3;

import static GL.GL.BLUE;
import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

import TP1.EX3.base.Fish;
import TP1.EX3.base.Horse;
import UTILS.EX;
import UTILS.EXEC;

public class Exec implements EXEC {

        @Override
        public void run() {
                EX ex = new EX(3, "Polymorphism", () -> {
                        System.out.println();
                        System.out.println(CYAN + "\t\tPolymorphism Example:" + RESET);
                        System.out.println("\t\tWe have defined two animal types: Fish and Horse.");
                        System.out.println("\t\tThey all share the same function 'Move' in the base class 'Animal',");
                        System.out.println("\t\tbut each applies it in a different way.");
                        System.out.println();

                        Fish fish = new Fish();
                        System.out.println(BLUE + "\t\t> Fish:" + RESET);
                        fish.Move();

                        Horse horse = new Horse();
                        System.out.println(BLUE + "\t\t> Horse:" + RESET);
                        horse.Move();

                        System.out.println();
                        System.out.println(
                                        GREEN + "\t\t✓ Common behavior:" + RESET + " All animals can " + YELLOW
                                                        + "Move()" + RESET + ".");
                        System.out.println(GREEN + "\t\t✓ Specialized behavior:" + RESET
                                        + " Each animal moves differently.");
                        System.out.println(
                                        MAGENTA + "\t\tPolymorphism allows a single interface to represent multiple behaviors."
                                                        + RESET);
                });

                System.out.println();
                System.out.println();
                System.out.println();
                ex.run();

        }

}
