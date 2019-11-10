public class AnimalFactory {

    public static Animal createAnimal(String animal) {

        switch (animal) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new RuntimeException("Cant produce this animal");
        }
    }
}