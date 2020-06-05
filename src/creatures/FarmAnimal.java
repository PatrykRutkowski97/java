package creatures;

public class FarmAnimal extends Animal implements Edbile {

    public FarmAnimal(String species, String name) {
        super(species, name);


    }

    @Override
    public void beEaten() {
        System.out.println("om.. om.. om.. what a tasty " + this.species + " " + this.name + ".");
    }
}
