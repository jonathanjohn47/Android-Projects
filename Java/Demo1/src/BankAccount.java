public class BankAccount {

    private int accNo;
    private String name;
    private int bal;

    public BankAccount() {
        accNo = 100;
        name = "NA";
        bal = 0;
    }

    public BankAccount( int ano, String n, int b ) {
        accNo = ano;
        name = n;
        bal = b;
    }

    public boolean deposit( int amt ) {

        if( amt <= 0 ) {
            return false;
        }

        this.bal += amt;
        return true;
    }

    public int withDraw( int amt ) {

        if( amt > bal ) {
            return 0;
        }

        bal = bal - amt;
        return amt;
    }

    public void display() {
        System.out.println(accNo + "\n" + name + "\n" + bal + "\n");
    }
}
