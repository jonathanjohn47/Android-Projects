public class Main {
    public static void main( String [] args ) {

        Printer printer = new Printer();

        new User("AA", printer ).start();
        new User("BB", printer ).start();
        new User("CC", printer ).start();
        new User("DD", printer ).start();

    }
}
