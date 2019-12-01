public class Main {

    public static void main( String [] args ) {

        //new Shape();

        Shape s = new Circle( 100, 100, 50 );
        s.draw();

        ( (Circle)s ).setR(90);
        //( (Rect)s ).setW(90); //Will not work
        s.draw();

        s = new Rect( 200, 200, 50, 60 );
        s.draw();
        ((Rect)s).setW( 80 );
        s.draw();

        Screen.drawToScreen( new Circle() );
        Screen.drawToScreen( new Rect() );
    }
}
