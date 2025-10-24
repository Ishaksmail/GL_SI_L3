package TP1.EX5;

import static GL.GL.BLUE;
import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

import TP1.EX5.base.Animal;
import TP1.EX5.base.Bird;
import TP1.EX5.base.Mammal;
import UTILS.EX;
import UTILS.EXEC;

public class Exec implements EXEC {

        @Override
        public void run() {

                EX ex = new EX(5, "", () -> {
                        System.out.println();
                        System.out.println(CYAN + "\t\tAbstraction Example:" + RESET);
                        System.out.println(
                                        "\t\tWe have defined two drawing types: CircleDrawing and RectangleDrawing.");
                        System.out.println(
                                        "\t\tBoth inherit from the abstract base class 'Drawing' and override the 'Draw' method,");
                        System.out.println("\t\tproviding their own specific implementations.");
                        System.out.println();

                        Animal circleDrawing = new Bird();
                        System.out.println(BLUE + "\t\t> Circle:" + RESET);
                        circleDrawing.Eat();

                        Animal rectangleDrawing = new Mammal();
                        System.out.println(BLUE + "\t\t> Rectangle:" + RESET);
                        rectangleDrawing.Eat();

                        System.out.println();
                        System.out.println(GREEN + "\t\t✓ Shared behavior:" + RESET + " All drawings implement the "
                                        + YELLOW + "Draw()" + RESET + " method.");
                        System.out.println(GREEN + "\t\t✓ Distinct behavior:" + RESET
                                        + " Each drawing type defines its own way of rendering shapes.");
                        System.out.println(MAGENTA
                                        + "\t\tAbstraction allows defining a general concept while hiding implementation details."
                                        + RESET);
                });

                ex.run();
        }

}
