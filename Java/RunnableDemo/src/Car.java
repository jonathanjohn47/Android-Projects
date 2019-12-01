public class Car implements Runnable {

    private int no;
    private String name;

    private boolean flag;

    public Car(int no, String name) {
        this.no = no;
        this.name = name;
        flag = true;

        //new Thread( this ).start();
    }

    public void start() {
        new Thread( this ).start();
    }

    public void stop() {
        flag = false;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while( flag ) {
            System.out.println( name  +" moving...");
            try {
                Thread.sleep( 50 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Race finished by: " + name );
    }
}


