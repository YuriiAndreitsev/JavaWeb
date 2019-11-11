@isBloxastiy(value = true)
public class Dog extends Dogs {
    @Color(color = "black")
    private String color;
    @Override
    public void makeNoise() {
        System.out.println("woof");
    }
}
