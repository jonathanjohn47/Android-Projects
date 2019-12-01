public class Base {

    private int b;

    public Base() {
        b = 1;
        System.out.println("Base()");
    }

    public Base( int b ) {
        this.b = b;
        System.out.println("Base( int )");
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void display() {
        System.out.println("b = " + b );
    }
}
