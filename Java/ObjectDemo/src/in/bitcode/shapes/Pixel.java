package in.bitcode.shapes;

public class Pixel  {

    private int x, y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void display() {
        System.out.println("x = " + x + " y = " + y );
    }
}
