@isBloxastiy(value = false)
public class Dog2 extends Dogs {
    @Color(color = "black")
    private String color;
    @Override
    public void makeNoise() {
        System.out.println("woof");
    }
}