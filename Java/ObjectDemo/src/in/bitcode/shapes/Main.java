package in.bitcode.shapes;

public class Main {

    public static void main( String [] args ) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        //Circle c2 = c1;

        //System.out.println( c1 == c2 );
        System.out.println( c1.equals(c2) );


        Rect r = new Rect();
        c1.equals( r );
        System.out.println( r.w + " " + r.h );


        /*
        Shape s = new Circle();
        System.out.println( s.hashCode() );
        System.out.println( s );
        System.out.println("Hello " + s );*/


    }

    //sample
    public static Object accept( Object o ) {
        int [] arr = new int[2];
        arr.toString();
        return new int[2];
    }
}
