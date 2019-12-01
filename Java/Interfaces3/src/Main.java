public class Main {

    public static void main( String [] args ) {

        /*Comparable c = new Student(11, "", 11 );
        c = new Emp( 11, "", 234 );
        */


        Emp [] arr = new Emp[5];
        arr[0] = new Emp(22, "CC", 1000 );
        arr[1] = new Emp(55, "AA", 200 );
        arr[2] = new Emp(11, "EE", 2020 );
        arr[3] = new Emp(9, "BB", 350 );
        arr[4] = new Emp(29, "DD", 900 );

        Util.sort( arr );
        for( Emp e : arr ) {
            System.out.println( e );
        }


        System.out.println();
        Util.sort( arr );
        for( Emp e : arr ) {
            System.out.println( e );
        }

        Student [] students = new Student[5];
        students[0] = new Student( 34, "ABC", 64.12f );
        students[1] = new Student( 42, "XYZ", 84.14f );
        students[2] = new Student( 12, "PQR", 46.52f );
        students[3] = new Student( 23, "LMN", 91.12f );
        students[4] = new Student( 25, "BDE", 29.32f );

        System.out.println();
        Util.sort( students );
        for( Student s : students ) {
            System.out.println( s );
        }


        /*int [] arr = { 50, 32, 23, 90, 81, 12, 30, 44 };
        Util.sort( arr );
        for( int val : arr ) {
            System.out.println( val );
        }*/



    }
}
