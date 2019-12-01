public class Main {
    public static void main( String [] args ) {

        int i = 1; //scan the value of i


        Base b1;

        if( i == 1 ) {
            b1 = new Derived();
        }
        else {
            b1 = new Base();
        }

        b1.display();

        //Derived d2 = new Base(); //does not work

        Derived d1 = new Derived( 100, 200 );
        d1.display();

        /*
        System.out.println();

        Derived d2 = new Derived();*/


        /*d1.setData( 100, 200 );
        d1.display();*/


        /*Derived d = new Derived();
        d.setB( 100 );
        System.out.println( d.getB() );
        d.displayB();

        Base b = new Base();
        b.setB( 200 );

        System.out.println( d.getB() );*/

    }
}
