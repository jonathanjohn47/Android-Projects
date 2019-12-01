public class Main {
    public static void main( String [] args ) {

        BankAccount b1 = new BankAccount();
        b1.display();
        b1.deposit( 1000 );
        b1.display();


        BankAccount b2 = new BankAccount( 200, "Vishal", 2000 );
        b2.display();
    }
}
