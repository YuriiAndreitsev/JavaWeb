@isBloxastiy(value = false)
public class Cat2 extends Cats {

    @Color(color = "black")
    private String color;

    @Override
    public void makeNoise() {
        System.out.println("meow2");
    }
}
