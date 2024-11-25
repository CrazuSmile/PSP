public class Hilo1 extends Thread {
    private int lowLimit, highLimit;

    public Hilo1(String nom, int lowLimit, int highLimit) {
        super(nom);
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public int getValue() {
        return (int) (Math.random() * (highLimit - lowLimit + 1)) + lowLimit;
    }
}
