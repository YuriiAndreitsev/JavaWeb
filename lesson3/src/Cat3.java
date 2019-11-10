@isBloxastiy(value = false)
public class Cat3 extends Cats {

    @Color(color = "white")
    private String color;

    @Override
    public void makeNoise() {
        System.out.println("meow3");
    }
}
