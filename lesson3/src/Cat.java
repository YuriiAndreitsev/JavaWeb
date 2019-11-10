@isBloxastiy(value = true)
public class Cat extends Cats {

    @Color(color = "black")
    private String color;

    @Override
    public void makeNoise() {
        System.out.println("meow");
    }
}
