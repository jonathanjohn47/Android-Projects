public class Container {

    private int data;
    private boolean isSet = false;

    public synchronized void put( int data ) {

        if( isSet == false ) {

            this.data = data;
            isSet = true;

            System.out.println("Put: " + data );

            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  synchronized void get() {

        if( isSet == true ) {

            System.out.println("Got: " + data );

            isSet = false;

            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}



interface One {
    void f1();

}

interface  Two {
    void f2();
}

interface SomeIntf extends One, Two {
    void some();
}















