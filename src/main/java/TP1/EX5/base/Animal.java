package TP1.EX5.base;

public abstract class Animal {
    private String Name;
    private String Species;
    private int Age;
    private String Diet;

    public abstract void Eat();

    public abstract void Sleep();

    public void setAge(int age) {
        Age = age;
    }

    public void setDiet(String diet) {
        Diet = diet;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public int getAge() {
        return Age;
    }

    public String getDiet() {
        return Diet;
    }

    public String getName() {
        return Name;
    }

    public String getSpecies() {
        return Species;
    }
}
