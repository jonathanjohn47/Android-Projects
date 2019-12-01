public class User extends Thread {

    private String userName;
    private Printer printer;

    public User(String userName, Printer printer) {
        this.userName = userName;
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized ( printer ) {
            printer.print(userName);
        }
    }
}
