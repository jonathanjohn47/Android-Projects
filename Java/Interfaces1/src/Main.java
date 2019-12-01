public class Main {
    public static void main( String [] args ) {

        Person p1 = new Person("676754332", "AA");
        Alien a1 = new Alien("Tuxuz", "Mars");

        p1.rule1();
        p1.rule2();
        p1.rule3();

        System.out.println();

        a1.rule1();
        a1.rule2();
        a1.rule3();

        System.out.println();

        Rules r = p1;
        r.rule1();
        r.rule2();
        r.rule3();
        System.out.println( ((Person) r).getaNo() );
        //r = a1;

    }
}
