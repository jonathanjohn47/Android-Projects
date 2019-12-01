public class Main {

    public static void main( String [] args ) {

        //some code

        //Maths maths = new Maths();
        Maths maths = Maths.getInstance();
        int val = maths.add( 100, 200 );

        //lots of code

        //Maths maths1 = new Maths();
        Maths maths1 = Maths.getInstance();
        val = maths.sub( 10, 20 );

    }
}
