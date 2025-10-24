package TP1.EX1;

import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

import TP1.EX1.base.Rectangle;
import UTILS.EX;
import UTILS.EXEC;

public class Exec implements EXEC {

        @Override
        public void run() {
                EX ex = new EX(1, "Encapsulation", () -> {
                        float width = 10;
                        float height = 20;
                        Rectangle rectangle = new Rectangle(height, width);
                        System.out.println();
                        System.out.println(CYAN + "\t\tEncapsulation Example:" + RESET);
                        System.out.println("\t\tUsing Getters to retrieve: width, height, area, and perimeter");
                        System.out.println(GREEN + "\t\t> { width : " + YELLOW + rectangle.getWidth() + " unit" + RESET
                                        +
                                        GREEN + ", height : " + YELLOW + rectangle.getHeight() + " unit }" + RESET);
                        System.out.println(GREEN + "\t\t> { area : " + YELLOW + rectangle.getArea() + " unit²" + RESET +
                                        GREEN + ", perimeter : " + YELLOW + rectangle.getPerimeter() + " unit }"
                                        + RESET);
                        System.out.println(MAGENTA + "\t\tEncapsulation ensures data hiding and controlled access."
                                        + RESET);
                });

                System.out.println();
                System.out.println();
                System.out.println();
                ex.run();

        }
}
