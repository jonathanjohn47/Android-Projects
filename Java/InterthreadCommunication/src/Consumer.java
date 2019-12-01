public class Consumer extends Thread {

    private Container c;

    public Consumer(Container c) {
        this.c = c;
    }

    @Override
    public void run() {
        while ( true ) {
            c.get();
        }
    }
}
