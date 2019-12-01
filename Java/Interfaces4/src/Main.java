public class Main {
    public static void main( String [] args ) {

        Customer c = new Customer(11, "AA");
        BankAccount b = new BankAccount(1011, "BAAA");
        Emp e = new Emp( 2022, "XYZ", 1000 );

        TestingTool.test(c);
        System.out.println();
        TestingTool.test(b);
        System.out.println();
        TestingTool.test(e);
        System.out.println();

    }
}
