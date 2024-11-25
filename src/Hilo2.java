public class Hilo2 extends Thread {
    private int lowLimit, highLimit;

    public Hilo2(String nom, int lowLimit, int highLimit) {
        super(nom);
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public int getValue() {
        return (int) (Math.random() * (highLimit - lowLimit + 1)) + lowLimit;
    }
}
