public class Main {
    public static void main( String [] args ){

        Emp e2 = new Emp( 22, "BB", 2000, 12, 12, 1999 );

        e2.display();
        System.out.println();
        Date dob = e2.getDob();
        dob.setYear( 2009 );
        e2.display();



        /*Date d1 = new Date( 11, 11, 2000 );

        Emp e1 = new Emp( 11, "AA", 1000, d1 );

        e1.display();
        System.out.println();

        e1.setDOB(12,12, 2004 );
        e1.display();
        System.out.println();

        d1.setYear( 2010 );
        e1.display();*/

    }
}
