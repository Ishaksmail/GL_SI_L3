package TP1.EX5;

import static GL.GL.BLUE;
import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

import java.util.ArrayList;

import TP1.EX5.base.Animal;
import TP1.EX5.base.Bird;
import TP1.EX5.base.Mammal;
import TP1.EX5.base.Reptile;
import UTILS.EX;
import UTILS.EXEC;

public class Exec implements EXEC {

        @Override
        public void run() {

                EX ex = new EX(5, "Object-Oriented Programming", () -> {
                        System.out.println();
                        System.out.println(CYAN
                                        + "\t\tAbstraction, Encapsulation, Inheritance, and Polymorphism"
                                        + RESET);
                        System.out.println();
                        System.out.println(GREEN + "\t[1] Abstraction:" + RESET);
                        System.out.println("\t\tWe begin by defining an abstract class called " + YELLOW + "Animal"
                                        + RESET + ".");
                        System.out.println(
                                        "\t\tIt represents a general concept of an animal, without specifying details.");
                        System.out.println(
                                        "\t\tThe class contains common properties such as name, age, species, and diet.");
                        System.out.println("\t\tIt also declares abstract methods like " + YELLOW + "Eat()" + RESET
                                        + " and " + YELLOW + "Sleep()" + RESET + ".");
                        System.out.println("\t\tThese methods will be implemented differently in each subclass.");
                        System.out.println();

                        System.out.println(GREEN + "\t[2] Encapsulation:" + RESET);
                        System.out.println(
                                        "\t\tAll properties of the Animal class are private, meaning they are hidden from direct access.");
                        System.out.println(
                                        "\t\tWe use getter and setter methods to access and modify these properties safely.");
                        System.out.println(
                                        "\t\tThis helps maintain data integrity and prevents unintended modification.");
                        System.out.println();

                        System.out.println(GREEN + "\t[3] Inheritance:" + RESET);
                        System.out.println(
                                        "\t\tWe create specific animal types that inherit from the abstract Animal class:");
                        System.out.println("\t\t" + YELLOW + "- Mammal, Bird, and Reptile" + RESET + ".");
                        System.out.println(
                                        "\t\tEach subclass inherits the basic structure but adds unique properties:");
                        System.out.println("\t\t\t• Mammal → has 'furColor'");
                        System.out.println("\t\t\t• Bird → has 'wingSpan'");
                        System.out.println("\t\t\t• Reptile → has 'scaleType'");
                        System.out.println("\t\tThis demonstrates code reusability through inheritance.");
                        System.out.println();

                        System.out.println(GREEN + "\t[4] Polymorphism:" + RESET);
                        System.out.println("\t\tEach subclass overrides the " + YELLOW + "Eat()" + RESET + " and "
                                        + YELLOW + "Sleep()" + RESET + " methods.");
                        System.out.println(
                                        "\t\tThis means the same method name behaves differently depending on the object type.");
                        System.out.println("\t\tAdditionally, we define an interface " + YELLOW + "IWalk" + RESET
                                        + " with a method " + YELLOW + "Walk()" + RESET + ".");
                        System.out.println(
                                        "\t\tDifferent animals implement this interface to provide unique walking behaviors.");
                        System.out.println();

                        System.out.println(GREEN + "\t[5] Abstraction Reinforced:" + RESET);
                        System.out.println(
                                        "\t\tBy keeping 'Animal' and 'IWalk' abstract, we ensure that only concrete subclasses can be instantiated.");
                        System.out.println(
                                        "\t\tThis allows us to define a general blueprint while forcing subclasses to implement specific logic.");
                        System.out.println();

                        System.out.println(GREEN + "\t[6] Testing and Demonstration:" + RESET);
                        System.out.println("\t\tNow, let’s create instances of each subclass and call their methods.");
                        System.out.println(
                                        "\t\tWe’ll observe how abstraction and polymorphism work together in action.");
                        System.out.println();
                        System.out.println(
                                        "\tCreating objects from different animal classes and invoking their methods to verify functionality.\n");

                        // Bird
                        Animal animalBird = new Bird();
                        System.out.println(BLUE + "\t\t> Bird:" + RESET);
                        animalBird.Eat();
                        animalBird.Sleep();
                        ((Bird) animalBird).Walk();

                        // Mammal
                        Animal animalMammal = new Mammal();
                        System.out.println(BLUE + "\t\t> Mammal:" + RESET);
                        animalMammal.Eat();
                        animalMammal.Sleep();
                        ((Mammal) animalMammal).Walk();

                        System.out.println(
                                        "\n\tUsing an Animal-type list to store various animal objects, then invoking the eat() and sleep() methods\n"
                                                        +
                                                        "\tthrough a loop to demonstrate polymorphism.\n");

                        // Reptile
                        Animal animalReptile = new Reptile();
                        System.out.println(BLUE + "\t\t> Reptile:" + RESET);
                        animalReptile.Eat();
                        animalReptile.Sleep();

                        ArrayList<Animal> animals = new ArrayList<Animal>();
                        // Adding animal objects to the Animal list
                        animals.add(animalMammal);
                        animals.add(animalBird);
                        animals.add(animalReptile);
                        animals.add(animalReptile);
                        animals.add(animalMammal);

                        int indexAnimal = 1;
                        for (Animal animal : animals) {
                                System.out.println(BLUE + "\t\t> Animal " + indexAnimal + " ("
                                                + animal.getClass().getSimpleName() + "):" + RESET);
                                animal.Eat();
                                animal.Sleep();
                                indexAnimal++;
                        }

                        System.out.println();
                        System.out.println(GREEN + "\t[7] Result Summary:" + RESET);
                        System.out.println("\t\t " + YELLOW + "Abstraction" + RESET
                                        + ": Common behavior is defined in the abstract class.");
                        System.out.println("\t\t " + YELLOW + "Encapsulation" + RESET
                                        + ": Data is protected using getters and setters.");
                        System.out.println("\t\t " + YELLOW + "Inheritance" + RESET
                                        + ": Shared structure extended by specific animal types.");
                        System.out.println("\t\t " + YELLOW + "Polymorphism" + RESET
                                        + ": Same methods behave differently for each subclass.");
                        System.out.println("\t\t " + YELLOW + "Interface" + RESET
                                        + ": Provides flexibility for shared behavior (e.g., walking).");
                        System.out.println();

                        System.out.println(MAGENTA
                                        + "\t\tThis exercise demonstrates how OOP principles work together to create clean, modular, and extensible code."
                                        + RESET);
                });

                ex.run();
        }

}
