public class Derived extends Base {

    private int d;

    public Derived() {
        super();
        d = 2;
        System.out.println("Derived()");
    }

    public Derived( int b, int d ) {
        super( b );
        this.d = d;
        System.out.println("Derived( int, int )");
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setData( int b, int d ) {
        setB( b );
        this.d = d;
    }

    public void display() {
        super.display();
        System.out.println("d = " + d);
    }
}
