public class Producer extends Thread {

    private Container c;

    public Producer(Container c) {
        this.c = c;
    }

    @Override
    public void run() {

        int i = 0;

        while ( true ) {
            c.put(i++);
        }

    }
}
