public class Main {
    public static void main( String [] args ) {

        //print college name?
        //System.out.println( Student.college );

        System.out.println( Student.getCollege() );

        Student s1 = new Student( "AA");
        Student s2 = new Student( "BB");
        Student s3 = new Student( "CC");

        s1.display();
        s2.display();
        s3.display();

        System.out.println();

        s1.setCollege("XYZ-New");

        s1.display();
        s2.display();
        s3.display();

    }
}
