public class Main {

    public static void main( String [] args ) {

        /*new Car( 123, "XYZ");
        new Car( 456, "LMN");*/


        /*Car c1 = new Car(123, "XYZ");
        Thread t1 = new Thread( c1 );
        t1.start();

        new Thread( new Car( 456, "LMN") ).start();*/


        Car c1 = new Car( 123, "XYZ");
        Car c2 = new Car( 456, "LMN");

        c1.start();
        c2.start();

        for( int i = 0; i < 10; i++ ) {
            try {
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Point " + i + " cleared!");
        }

        c1.stop();
        c2.stop();

    }
}
