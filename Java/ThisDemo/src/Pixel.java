public class Pixel {

    private int x, y;

    public Pixel() {
        this( 0, 0 );
        /*this.x = 0;
        this.y = 0;*/
    }

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordinates( int x, int y ) {
        this.setX( x );
        this.setY( y );
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

    public void draw() {
        System.out.println("x = " + this.x + " y = " + this.y);
    }

}
