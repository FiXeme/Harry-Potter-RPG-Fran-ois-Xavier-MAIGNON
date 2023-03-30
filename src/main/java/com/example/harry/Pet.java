import java.util.Random;

public enum Pet {
    pikachu("Pikachu"),
    chenipan("Chenipan"),
    ratata("Ratata"),
    fulgudog("Fulgudog"),
    mimigal("Mimigal");
    private String name;
    Pet(String name) {
        this.name = name;
    }
    private static final Random PRNG = new Random();
    public static Pet randomPet() {
        Pet[] pets = values();
        return pets[PRNG.nextInt(pets.length)];
    }


}
